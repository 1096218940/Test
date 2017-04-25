package com.ma.chasheng.chalutong.api.bean;

import java.util.List;

/**
 * Created by mapingan
 * on 2017/4/25 0025.
 */

public class HomeListBean {


    private List<FloorListBean> floorList;
    private List<AppIndexAdListBean> appIndexAdList;
    private List<StoreListBean> storeList;
    private List<AppIconListBean> appIconList;

    public List<FloorListBean> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<FloorListBean> floorList) {
        this.floorList = floorList;
    }

    public List<AppIndexAdListBean> getAppIndexAdList() {
        return appIndexAdList;
    }

    public void setAppIndexAdList(List<AppIndexAdListBean> appIndexAdList) {
        this.appIndexAdList = appIndexAdList;
    }

    public List<StoreListBean> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<StoreListBean> storeList) {
        this.storeList = storeList;
    }

    public List<AppIconListBean> getAppIconList() {
        return appIconList;
    }

    public void setAppIconList(List<AppIconListBean> appIconList) {
        this.appIconList = appIconList;
    }

    public static class FloorListBean {
        /**
         * advKey : app_index_floor1
         * advPositionVo : {"isUse":1,"apWidth":100,"apId":"c30893f446464e32ac1f038d01828bc8","apIntro":"APP-首页-楼层1","apName":"APP-首页-楼层1","apClass":"0","advList":[{"advUrl":"WEB:","endDate":1513485888000,"apId":"c30893f446464e32ac1f038d01828bc8","advTitle":"0","endDateStr":"2017-12-17 12:44:48","resUrl":"/upload/img/adv/1481949883216.jpg","startDateStr":"2016-12-17 12:44:46","endtDateStr":"2017-12-17 12:44:48","advId":"e9fd5910d9d24afab51eb12fd9f0c5cc","sort":0,"startDate":1481949886000},{"advUrl":"WEB:","endDate":1513485930000,"apId":"c30893f446464e32ac1f038d01828bc8","advTitle":"1","endDateStr":"2017-12-17 12:45:30","resUrl":"/upload/img/adv/1481949923538.jpg","startDateStr":"2016-12-17 12:45:28","endtDateStr":"2017-12-17 12:45:30","advId":"112053b94f404a47af64ac630c3a7ed3","sort":1,"startDate":1481949928000},{"advUrl":"WEB:","endDate":1513486052000,"apId":"c30893f446464e32ac1f038d01828bc8","advTitle":"2","endDateStr":"2017-12-17 12:47:32","resUrl":"/upload/img/adv/1481950047757.jpg","startDateStr":"2016-12-17 12:47:30","endtDateStr":"2017-12-17 12:47:32","advId":"a61d4ebd28164ef29a2c0ed5cc39891e","sort":2,"startDate":1481950050000},{"advUrl":"WEB:","endDate":1513486084000,"apId":"c30893f446464e32ac1f038d01828bc8","advTitle":"3","endDateStr":"2017-12-17 12:48:04","resUrl":"/upload/img/adv/1481950079484.png","startDateStr":"2016-12-17 12:48:02","endtDateStr":"2017-12-17 12:48:04","advId":"d9ee2f5150e748cf8c5a2f75567814e9","sort":3,"startDate":1481950082000}],"apKey":"app_index_floor1","apHeight":100}
         * floorColor : green
         * floorImg : /upload/img/adv/1481950601135.jpg
         * subName : 特色推荐
         * gcId :
         * bannerUrl :
         * floorName : 特色推荐
         * sort : 1
         * bannerImg : /upload/img/adv/1481950595600.jpg
         * isShow : 1
         */

        private String advKey;
        private AdvPositionVoBean advPositionVo;
        private String floorColor;
        private String floorImg;
        private String subName;
        private String gcId;
        private String bannerUrl;
        private String floorName;
        private int sort;
        private String bannerImg;
        private int isShow;

        public String getAdvKey() {
            return advKey;
        }

        public void setAdvKey(String advKey) {
            this.advKey = advKey;
        }

        public AdvPositionVoBean getAdvPositionVo() {
            return advPositionVo;
        }

        public void setAdvPositionVo(AdvPositionVoBean advPositionVo) {
            this.advPositionVo = advPositionVo;
        }

        public String getFloorColor() {
            return floorColor;
        }

        public void setFloorColor(String floorColor) {
            this.floorColor = floorColor;
        }

        public String getFloorImg() {
            return floorImg;
        }

        public void setFloorImg(String floorImg) {
            this.floorImg = floorImg;
        }

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }

        public String getGcId() {
            return gcId;
        }

        public void setGcId(String gcId) {
            this.gcId = gcId;
        }

        public String getBannerUrl() {
            return bannerUrl;
        }

        public void setBannerUrl(String bannerUrl) {
            this.bannerUrl = bannerUrl;
        }

        public String getFloorName() {
            return floorName;
        }

        public void setFloorName(String floorName) {
            this.floorName = floorName;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getBannerImg() {
            return bannerImg;
        }

        public void setBannerImg(String bannerImg) {
            this.bannerImg = bannerImg;
        }

        public int getIsShow() {
            return isShow;
        }

        public void setIsShow(int isShow) {
            this.isShow = isShow;
        }

        public static class AdvPositionVoBean {
            /**
             * isUse : 1
             * apWidth : 100
             * apId : c30893f446464e32ac1f038d01828bc8
             * apIntro : APP-首页-楼层1
             * apName : APP-首页-楼层1
             * apClass : 0
             * advList : [{"advUrl":"WEB:","endDate":1513485888000,"apId":"c30893f446464e32ac1f038d01828bc8","advTitle":"0","endDateStr":"2017-12-17 12:44:48","resUrl":"/upload/img/adv/1481949883216.jpg","startDateStr":"2016-12-17 12:44:46","endtDateStr":"2017-12-17 12:44:48","advId":"e9fd5910d9d24afab51eb12fd9f0c5cc","sort":0,"startDate":1481949886000},{"advUrl":"WEB:","endDate":1513485930000,"apId":"c30893f446464e32ac1f038d01828bc8","advTitle":"1","endDateStr":"2017-12-17 12:45:30","resUrl":"/upload/img/adv/1481949923538.jpg","startDateStr":"2016-12-17 12:45:28","endtDateStr":"2017-12-17 12:45:30","advId":"112053b94f404a47af64ac630c3a7ed3","sort":1,"startDate":1481949928000},{"advUrl":"WEB:","endDate":1513486052000,"apId":"c30893f446464e32ac1f038d01828bc8","advTitle":"2","endDateStr":"2017-12-17 12:47:32","resUrl":"/upload/img/adv/1481950047757.jpg","startDateStr":"2016-12-17 12:47:30","endtDateStr":"2017-12-17 12:47:32","advId":"a61d4ebd28164ef29a2c0ed5cc39891e","sort":2,"startDate":1481950050000},{"advUrl":"WEB:","endDate":1513486084000,"apId":"c30893f446464e32ac1f038d01828bc8","advTitle":"3","endDateStr":"2017-12-17 12:48:04","resUrl":"/upload/img/adv/1481950079484.png","startDateStr":"2016-12-17 12:48:02","endtDateStr":"2017-12-17 12:48:04","advId":"d9ee2f5150e748cf8c5a2f75567814e9","sort":3,"startDate":1481950082000}]
             * apKey : app_index_floor1
             * apHeight : 100
             */

            private int isUse;
            private int apWidth;
            private String apId;
            private String apIntro;
            private String apName;
            private String apClass;
            private String apKey;
            private int apHeight;
            private List<AdvListBean> advList;

            public int getIsUse() {
                return isUse;
            }

            public void setIsUse(int isUse) {
                this.isUse = isUse;
            }

            public int getApWidth() {
                return apWidth;
            }

            public void setApWidth(int apWidth) {
                this.apWidth = apWidth;
            }

            public String getApId() {
                return apId;
            }

            public void setApId(String apId) {
                this.apId = apId;
            }

            public String getApIntro() {
                return apIntro;
            }

            public void setApIntro(String apIntro) {
                this.apIntro = apIntro;
            }

            public String getApName() {
                return apName;
            }

            public void setApName(String apName) {
                this.apName = apName;
            }

            public String getApClass() {
                return apClass;
            }

            public void setApClass(String apClass) {
                this.apClass = apClass;
            }

            public String getApKey() {
                return apKey;
            }

            public void setApKey(String apKey) {
                this.apKey = apKey;
            }

            public int getApHeight() {
                return apHeight;
            }

            public void setApHeight(int apHeight) {
                this.apHeight = apHeight;
            }

            public List<AdvListBean> getAdvList() {
                return advList;
            }

            public void setAdvList(List<AdvListBean> advList) {
                this.advList = advList;
            }

            public static class AdvListBean {
                /**
                 * advUrl : WEB:
                 * endDate : 1513485888000
                 * apId : c30893f446464e32ac1f038d01828bc8
                 * advTitle : 0
                 * endDateStr : 2017-12-17 12:44:48
                 * resUrl : /upload/img/adv/1481949883216.jpg
                 * startDateStr : 2016-12-17 12:44:46
                 * endtDateStr : 2017-12-17 12:44:48
                 * advId : e9fd5910d9d24afab51eb12fd9f0c5cc
                 * sort : 0
                 * startDate : 1481949886000
                 */

                private String advUrl;
                private long endDate;
                private String apId;
                private String advTitle;
                private String endDateStr;
                private String resUrl;
                private String startDateStr;
                private String endtDateStr;
                private String advId;
                private int sort;
                private long startDate;

                public String getAdvUrl() {
                    return advUrl;
                }

                public void setAdvUrl(String advUrl) {
                    this.advUrl = advUrl;
                }

                public long getEndDate() {
                    return endDate;
                }

                public void setEndDate(long endDate) {
                    this.endDate = endDate;
                }

                public String getApId() {
                    return apId;
                }

                public void setApId(String apId) {
                    this.apId = apId;
                }

                public String getAdvTitle() {
                    return advTitle;
                }

                public void setAdvTitle(String advTitle) {
                    this.advTitle = advTitle;
                }

                public String getEndDateStr() {
                    return endDateStr;
                }

                public void setEndDateStr(String endDateStr) {
                    this.endDateStr = endDateStr;
                }

                public String getResUrl() {
                    return resUrl;
                }

                public void setResUrl(String resUrl) {
                    this.resUrl = resUrl;
                }

                public String getStartDateStr() {
                    return startDateStr;
                }

                public void setStartDateStr(String startDateStr) {
                    this.startDateStr = startDateStr;
                }

                public String getEndtDateStr() {
                    return endtDateStr;
                }

                public void setEndtDateStr(String endtDateStr) {
                    this.endtDateStr = endtDateStr;
                }

                public String getAdvId() {
                    return advId;
                }

                public void setAdvId(String advId) {
                    this.advId = advId;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public long getStartDate() {
                    return startDate;
                }

                public void setStartDate(long startDate) {
                    this.startDate = startDate;
                }
            }
        }
    }

    public static class AppIndexAdListBean {
        /**
         * advUrl : WEB:
         * endDate : 1513487540000
         * apId : 4089e207d08841c983091601a8e67b67
         * advTitle : APP-首页-轮播0
         * endDateStr : 2017-12-17 13:12:20
         * resUrl : /upload/img/adv/1481951536155.jpg
         * startDateStr : 2016-12-17 13:12:18
         * endtDateStr : 2017-12-17 13:12:20
         * advId : 2027d51f7c1f49d99f38903c5a891c54
         * sort : 0
         * startDate : 1481951538000
         */

        private String advUrl;
        private long endDate;
        private String apId;
        private String advTitle;
        private String endDateStr;
        private String resUrl;
        private String startDateStr;
        private String endtDateStr;
        private String advId;
        private int sort;
        private long startDate;

        public String getAdvUrl() {
            return advUrl;
        }

        public void setAdvUrl(String advUrl) {
            this.advUrl = advUrl;
        }

        public long getEndDate() {
            return endDate;
        }

        public void setEndDate(long endDate) {
            this.endDate = endDate;
        }

        public String getApId() {
            return apId;
        }

        public void setApId(String apId) {
            this.apId = apId;
        }

        public String getAdvTitle() {
            return advTitle;
        }

        public void setAdvTitle(String advTitle) {
            this.advTitle = advTitle;
        }

        public String getEndDateStr() {
            return endDateStr;
        }

        public void setEndDateStr(String endDateStr) {
            this.endDateStr = endDateStr;
        }

        public String getResUrl() {
            return resUrl;
        }

        public void setResUrl(String resUrl) {
            this.resUrl = resUrl;
        }

        public String getStartDateStr() {
            return startDateStr;
        }

        public void setStartDateStr(String startDateStr) {
            this.startDateStr = startDateStr;
        }

        public String getEndtDateStr() {
            return endtDateStr;
        }

        public void setEndtDateStr(String endtDateStr) {
            this.endtDateStr = endtDateStr;
        }

        public String getAdvId() {
            return advId;
        }

        public void setAdvId(String advId) {
            this.advId = advId;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public long getStartDate() {
            return startDate;
        }

        public void setStartDate(long startDate) {
            this.startDate = startDate;
        }
    }

    public static class StoreListBean {
        /**
         * storeShowImgs : ["/upload/system/logo_80x80.png","/upload/system/logo_80x80.png","/upload/system/logo_80x80.png"]
         * storeLogo : /upload/system/logo_80x80.png
         * storeName : 财源滚滚
         * storeRemark :
         * storeId : 0988e6e52dc64ef99b34037abb583b8c
         */

        private String storeLogo;
        private String storeName;
        private String storeRemark;
        private String storeId;
        private List<String> storeShowImgs;

        public String getStoreLogo() {
            return storeLogo;
        }

        public void setStoreLogo(String storeLogo) {
            this.storeLogo = storeLogo;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getStoreRemark() {
            return storeRemark;
        }

        public void setStoreRemark(String storeRemark) {
            this.storeRemark = storeRemark;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public List<String> getStoreShowImgs() {
            return storeShowImgs;
        }

        public void setStoreShowImgs(List<String> storeShowImgs) {
            this.storeShowImgs = storeShowImgs;
        }
    }

    public static class AppIconListBean {
    }
}
