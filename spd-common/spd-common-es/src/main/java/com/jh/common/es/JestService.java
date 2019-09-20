package com.jh.common.es;

import com.alibaba.fastjson.JSON;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.mapping.GetMapping;
import io.searchbox.indices.mapping.PutMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JestService {
    private static final Logger logger = LoggerFactory.getLogger(JestService.class.getName());

    /**
     * 创建索引
     *
     * @param jestClient
     * @param indexName
     * @return
     * @throws Exception
     */
    public boolean createIndex(JestClient jestClient, String indexName) throws Exception {

        JestResult jr = jestClient.execute(new CreateIndex.Builder(indexName).build());
        logger.info("createIndex结果{}", jr.getResponseCode() + ";" + jr.getErrorMessage());
        return jr.isSucceeded();
    }

    /**
     * Put映射
     *
     * @param jestClient
     * @param indexName
     * @param typeName
     * @param source
     * @return
     * @throws Exception
     */
    public boolean createIndexMapping(JestClient jestClient, String indexName, String typeName, String source) throws Exception {

        PutMapping putMapping = new PutMapping.Builder(indexName, typeName, source).build();
        JestResult jr = jestClient.execute(putMapping);
        logger.info("createIndexMapping同步结果{}", jr.getResponseCode() + ";" + jr.getErrorMessage());
//        logger.info("createIndexMapping同步结果详情{}", JSON.toJSONString(jr.getJsonObject()));
        return jr.isSucceeded();
    }

    /**
     * Get映射
     *
     * @param jestClient
     * @param indexName
     * @param typeName
     * @return
     * @throws Exception
     */
    public String getIndexMapping(JestClient jestClient, String indexName, String typeName) throws Exception {

        GetMapping getMapping = new GetMapping.Builder().addIndex(indexName).addType(typeName).build();
        JestResult jr = jestClient.execute(getMapping);
        return jr.getJsonString();
    }

    /**
     * 索引文档
     *
     * @param jestClient
     * @param indexName
     * @param typeName
     * @param objs
     * @return
     * @throws Exception
     */
    public boolean index(JestClient jestClient, String indexName, String typeName, List<Object> objs) throws Exception {

        Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName);
        for (Object obj : objs) {
            Index index = new Index.Builder(obj).build();
            bulk.addAction(index);
        }
        BulkResult br = jestClient.execute(bulk.build());
        return br.isSucceeded();
    }

    public boolean index(JestClient jestClient, String indexName, String typeName, List objs, List<String> ids) throws Exception {
        logger.info("开始同步{},同步内容{}", indexName, JSON.toJSONString(objs));
        Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName);
        for (int i = 0; i < objs.size(); i++) {
            Index index = new Index.Builder(objs.get(i)).id(ids.get(i)).build();
            bulk.addAction(index);
        }
        bulk.refresh(true);
        BulkResult br = jestClient.execute(bulk.build());
        logger.info("index同步结果{}", br.getResponseCode() + ";" + br.getErrorMessage());
        logger.info("index同步失败结果详情{}", JSON.toJSONString(br.getFailedItems()));
        logger.info("index同步结果详情{}", JSON.toJSONString(br.getItems()));
        return br.isSucceeded();
    }

    public boolean update(JestClient jestClient, String indexName, String typeName, List objs, List<String> ids) throws Exception {

        Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName);
        for (int i = 0; i < objs.size(); i++) {
            Update index = new Update.Builder(objs.get(i)).id(ids.get(i)).build();
            bulk.addAction(index);
        }
        bulk.refresh(true);
        BulkResult br = jestClient.execute(bulk.build());
        return br.isSucceeded();
    }


    /**
     * 搜索文档
     *
     * @param jestClient
     * @param indexName
     * @param typeName
     * @param query
     * @return
     * @throws Exception
     */
    public SearchResult search(JestClient jestClient, String indexName, String typeName, String query) throws Exception {

        Search search = new Search.Builder(query)
                .addIndex(indexName)
                .addType(typeName)
                .build();
        return jestClient.execute(search);
    }

    /**
     * 搜索文档
     *
     * @param jestClient
     * @param indexName
     * @param query
     * @return
     * @throws Exception
     */
    public SearchResult search(JestClient jestClient, String indexName, String query) throws Exception {

        Search search = new Search.Builder(query)
                .addIndex(indexName)
                .build();
        return jestClient.execute(search);
    }


    /**
     * Count文档
     *
     * @param jestClient
     * @param indexName
     * @param typeName
     * @param query
     * @return
     * @throws Exception
     */
    public Double count(JestClient jestClient, String indexName, String typeName, String query) throws Exception {

        Count count = new Count.Builder()
                .addIndex(indexName)
                .addType(typeName)
                .query(query)
                .build();
        CountResult results = jestClient.execute(count);
        return results.getCount();
    }

    /**
     * Get文档
     *
     * @param jestClient
     * @param indexName
     * @param typeName
     * @param id
     * @return
     * @throws Exception
     */
    public JestResult get(JestClient jestClient, String indexName, String typeName, String id) throws Exception {

        Get get = new Get.Builder(indexName, id).type(typeName).build();
        return jestClient.execute(get);
    }

    /**
     * Delete索引
     *
     * @param jestClient
     * @param indexName
     * @return
     * @throws Exception
     */
    public boolean delete(JestClient jestClient, String indexName) throws Exception {

        JestResult jr = jestClient.execute(new DeleteIndex.Builder(indexName).build());
        return jr.isSucceeded();
    }

    public boolean deleteByQuery(JestClient jestClient, String indexName, String query) throws Exception {
        JestResult jr = jestClient.execute(new DeleteByQuery.Builder(query).addIndex(indexName).build());
        return jr.isSucceeded();
    }

    /**
     * Delete文档
     *
     * @param jestClient
     * @param indexName
     * @param typeName
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delete(JestClient jestClient, String indexName, String typeName, String id) throws Exception {

        DocumentResult dr = jestClient.execute(new Delete.Builder(id).index(indexName).type(typeName).build());
        return dr.isSucceeded();
    }

    /**
     * 关闭JestClient客户端
     *
     * @param jestClient
     * @throws Exception
     */
    public void closeJestClient(JestClient jestClient) throws Exception {

        if (jestClient != null) {
            jestClient.shutdownClient();
        }
    }


}
