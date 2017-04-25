package com.ma.chasheng.chalutong.api.bean;

import java.util.List;

/**
 * Created by mapingan
 * on 2017/4/25 0025.
 */

public class RecommendListBean {

    /**
     * result : [{"goodsStorePrice":0.01,"goodsImage":"/upload/img/store/0/1487647286009.jpg","goodsSolrMarketPrice":1,"goodsName":"【茶圣超市】拍下立减100 老缪家安吉白茶 80克*2盒共160克 安吉珍稀白茶叶","specId":"00c4d3b254024cd6badbf119ad99964f","goodsMarketPrice":1,"goodsPrice":0.01,"goodsId":"d85ca2361eb4430ea2f1bfcf12e706b5"},{"goodsStorePrice":89,"goodsImage":"/upload/img/store/0/1483520263900.jpg","goodsSolrMarketPrice":189,"goodsName":"2017碧螺春","specId":"7ad2b36712ab4f59b6d95a608791ec88","goodsMarketPrice":189,"goodsPrice":89,"goodsId":"356444e6e76f4c089b6c879f4ca7f90c"},{"goodsStorePrice":99,"goodsImage":"/upload/img/store/0/1481874312606.jpg","goodsSolrMarketPrice":999,"goodsName":"250g龙井绿茶茶叶 赛君王绿茶茶叶2016年新茶龙井茶龙井茶叶罐装春茶茶叶龙井茶茶叶袋装","specId":"d0015d7463c04892acde23c3c1ee1c5c","goodsMarketPrice":999,"goodsPrice":99,"goodsId":"3aa1d4919a8d42d0978ae418ec16accb"},{"goodsStorePrice":69,"goodsImage":"/upload/img/store/0/1481874107056.jpg","goodsSolrMarketPrice":169,"goodsName":"250g龙井绿茶茶叶 赛君王绿茶茶叶2016年新茶龙井茶龙井茶叶罐装春茶茶叶龙井茶茶叶袋装","specId":"94b463c4e25c41cda373232ef3ec8846","goodsMarketPrice":169,"goodsPrice":69,"goodsId":"ded2ec0b2b974c30b0cb1d4c8752ad99"},{"goodsStorePrice":11.21,"goodsImage":"/upload/img/store/10f65f92e99741c3b7cd9999daeadeef/1490235622091.jpg","goodsSolrMarketPrice":16,"goodsName":"湘丰茶叶 (测试商品，请勿购买)","specId":"e705950f31974d10ae62d7a65b7802d3","goodsMarketPrice":16,"goodsPrice":11.21,"goodsId":"1ed55148d7e94f0ba4491349473bd810"},{"goodsStorePrice":119,"goodsImage":"/upload/img/store/0/1481861982149.jpg","goodsSolrMarketPrice":399,"goodsName":"【不要礼盒加送250g】500g赛君王安溪铁观音礼盒茶叶礼盒装乌龙茶特级清香型铁观音茶叶","specId":"a6658f8f98d94d9bb65ba1501e265f24","goodsMarketPrice":399,"goodsPrice":119,"goodsId":"10fc92cba349431d94d87a544a3835b9"},{"goodsStorePrice":90,"goodsImage":"/upload/img/store/0/1481885346079.jpg","goodsSolrMarketPrice":165,"goodsName":"【茶圣超市】忆江南 茶叶 （龙井+碧螺春+普洱茶）茗茶组合装三罐 275g","specId":"68dcf130adfe41b18ae298d6aa2f17c1","goodsMarketPrice":165,"goodsPrice":90,"goodsId":"e408808bff9a434bad30e66d72d368db"},{"goodsStorePrice":0.01,"goodsImage":"/upload/img/store/0/1482283480991.jpg","goodsSolrMarketPrice":128,"goodsName":"黄山（测试规格）","specId":"b5f06f47739040f2b0f15094df7d904a","goodsMarketPrice":128,"goodsPrice":0.01,"goodsId":"3b94fa91d90441219c2923bceae5934e"},{"goodsStorePrice":5.99,"goodsImage":"/upload/img/store/0/1482144379340.jpg","goodsSolrMarketPrice":123,"goodsName":"【测试商品】500g赛君王安溪铁观音礼盒茶叶礼盒装乌龙茶特级清香型铁观音茶叶","specId":"b0d4352e4245402fa10f34ec641f97ec","goodsMarketPrice":123,"goodsPrice":5.99,"goodsId":"9a7eedc2725f43a7923ea7cb75e62b81"},{"goodsStorePrice":99,"goodsImage":"/upload/img/store/0/1482309274172.jpg","goodsSolrMarketPrice":199,"goodsName":"【茶圣超市】红尊 茶叶 红茶 正山小种 武夷桐木关红茶礼盒 500g","specId":"605c83f03ff942f3b212f34ea9c8258c","goodsMarketPrice":199,"goodsPrice":99,"goodsId":"45dc4b739412407e8f3e2bcd07762fa9"},{"goodsStorePrice":79,"goodsImage":"/upload/img/store/0/1483925991257.jpg","goodsSolrMarketPrice":99,"goodsName":"【茶圣超市】买1送1共516克绿茶叶 信阳原产毛尖春茶新茶 特尊","specId":"9944f1acfdbd4daba84a3426e3721d20","goodsMarketPrice":99,"goodsPrice":79,"goodsId":"cfc2f0dd5c83418abe8cdc8f0f172822"},{"goodsStorePrice":229,"goodsImage":"/upload/img/store/0/1486804662404.jpg","goodsSolrMarketPrice":400,"goodsName":"郁含香 碧螺春茶叶绿茶新茶125g*2罐","specId":"c055a606d48b440d9f38ef602989c4cd","goodsMarketPrice":400,"goodsPrice":229,"goodsId":"95cd0442d9974fd58873750e8841944d"}]
     * condition : {"recommendInfo":"app_index_goods"}
     * pageCount : 1
     * toUrl :
     * pageNo : 1
     * start : 0
     * orderBy : 0
     * pageSize : 20
     * totalRows : 12
     */

    private ConditionBean condition;
    private int pageCount;
    private String toUrl;
    private int pageNo;
    private int start;
    private int orderBy;
    private int pageSize;
    private int totalRows;
    private List<ResultBean> result;

    public ConditionBean getCondition() {
        return condition;
    }

    public void setCondition(ConditionBean condition) {
        this.condition = condition;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getToUrl() {
        return toUrl;
    }

    public void setToUrl(String toUrl) {
        this.toUrl = toUrl;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ConditionBean {
        /**
         * recommendInfo : app_index_goods
         */

        private String recommendInfo;

        public String getRecommendInfo() {
            return recommendInfo;
        }

        public void setRecommendInfo(String recommendInfo) {
            this.recommendInfo = recommendInfo;
        }
    }

    public static class ResultBean {
        /**
         * goodsStorePrice : 0.01
         * goodsImage : /upload/img/store/0/1487647286009.jpg
         * goodsSolrMarketPrice : 1
         * goodsName : 【茶圣超市】拍下立减100 老缪家安吉白茶 80克*2盒共160克 安吉珍稀白茶叶
         * specId : 00c4d3b254024cd6badbf119ad99964f
         * goodsMarketPrice : 1
         * goodsPrice : 0.01
         * goodsId : d85ca2361eb4430ea2f1bfcf12e706b5
         */

        private double goodsStorePrice;
        private String goodsImage;
        private int goodsSolrMarketPrice;
        private String goodsName;
        private String specId;
        private int goodsMarketPrice;
        private double goodsPrice;
        private String goodsId;

        public double getGoodsStorePrice() {
            return goodsStorePrice;
        }

        public void setGoodsStorePrice(double goodsStorePrice) {
            this.goodsStorePrice = goodsStorePrice;
        }

        public String getGoodsImage() {
            return goodsImage;
        }

        public void setGoodsImage(String goodsImage) {
            this.goodsImage = goodsImage;
        }

        public int getGoodsSolrMarketPrice() {
            return goodsSolrMarketPrice;
        }

        public void setGoodsSolrMarketPrice(int goodsSolrMarketPrice) {
            this.goodsSolrMarketPrice = goodsSolrMarketPrice;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getSpecId() {
            return specId;
        }

        public void setSpecId(String specId) {
            this.specId = specId;
        }

        public int getGoodsMarketPrice() {
            return goodsMarketPrice;
        }

        public void setGoodsMarketPrice(int goodsMarketPrice) {
            this.goodsMarketPrice = goodsMarketPrice;
        }

        public double getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(double goodsPrice) {
            this.goodsPrice = goodsPrice;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }
    }
}
