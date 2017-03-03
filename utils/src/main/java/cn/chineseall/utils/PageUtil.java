package cn.chineseall.utils;

import java.util.List;

public class PageUtil {

    public final static int PAGESIZE = 10;

    private int pageSize = PAGESIZE;

    private List items;

    private int totalCount;

    private int[] indexes = new int[0];

    private int startIndex = 0;

    private int currentPage = 0;

    private int nextPage = 0;

    private int prePage = 0;

    private int totalPage = 0;

    public PageUtil(List items, int totalCount) {
        setPageSize(PAGESIZE);
        setTotalCount(totalCount);
        setItems(items);
        setCurrentPage(1);
        setNextPage(1);
        setPrePage(1);
        setStartIndex(0);
        setTotalPage(totalCount / pageSize);
        if (totalCount % pageSize > 0) {
            this.totalPage++;
        }
    }

    public PageUtil(List items, int totalCount, int currentPage) {
        setPageSize(PAGESIZE);
        setTotalCount(totalCount);
        setItems(items);
        setTotalPage(totalCount / pageSize);
        if (totalCount % pageSize > 0) {
            this.totalPage++;
        }
        currentPage = currentPage > 0 ? currentPage : 1;
        currentPage = currentPage > totalPage ? totalPage : currentPage;
        setCurrentPage(currentPage);
        setStartIndex((currentPage - 1) * pageSize);
        setNextPage(currentPage >= totalPage ? totalPage : currentPage + 1);
        setPrePage(currentPage > 1 ? currentPage - 1 : 1);
    }

    public PageUtil(List items, int totalCount, int pageSize, int currentPage) {
        setPageSize(pageSize);
        setTotalCount(totalCount);
        setItems(items);

        setTotalPage(totalCount / pageSize);
        if (totalCount % pageSize > 0) {
            this.totalPage++;
        }
        currentPage = currentPage > 0 ? currentPage : 1;
        currentPage = currentPage > totalPage ? totalPage : currentPage;
        setCurrentPage(currentPage);
        setStartIndex((currentPage - 1) * pageSize);
        setNextPage(currentPage >= totalPage ? totalPage : currentPage + 1);
        setPrePage(currentPage > 1 ? currentPage - 1 : 1);
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
            int count = totalCount / pageSize;
            if (totalCount % pageSize > 0) {
                count++;
            }
            indexes = new int[count];
            for (int i = 0; i < count; i++) {
                indexes[i] = pageSize * i;
            }
        } else {
            this.totalCount = 0;
        }
    }

    public int[] getIndexes() {
        return indexes;
    }

    public void setIndexes(int[] indexes) {
        this.indexes = indexes;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        if (totalCount <= 0) {
            this.startIndex = 0;
        } else if (startIndex >= totalCount) {
            this.startIndex = indexes[indexes.length - 1];
        } else if (startIndex < 0) {
            this.startIndex = 0;
        } else {
            this.startIndex = indexes[startIndex / pageSize];
        }
    }

    public int getNextIndex() {
        int nextIndex = getStartIndex() + pageSize;
        if (nextIndex >= totalCount) {
            return getStartIndex();
        } else {
            return nextIndex;
        }
    }

    public int getPreviousIndex() {
        int previousIndex = getStartIndex() - pageSize;
        if (previousIndex < 0) {
            return 0;
        } else {
            return previousIndex;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }
}
