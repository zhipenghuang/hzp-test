package com.springmvc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class PageDto extends AbstractEntity {
    private int pageIndex;
    private int pageSize;
    private int dataCount;
    private List data;
    private Map<String, Object> otherField;

    public PageDto() {
        this.pageIndex = 0;
        this.pageSize = 10;
        this.dataCount = 0;
        this.data = new ArrayList(0);
        this.otherField = null;
    }

    public PageDto(int pageIndex, int pageSize, List data) {
        this(pageIndex, pageSize, -1, data);
    }

    public PageDto(int pageIndex, int pageSize, int dataCount, List data) {
        this.pageIndex = 0;
        this.pageSize = 10;
        this.dataCount = 0;
        this.data = new ArrayList(0);
        this.otherField = null;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.dataCount = dataCount;
        this.setData(data);
    }

    public void setData(List data) {
        this.data = (List)(data == null?new ArrayList(0):data);
    }

    public void addField(String key, Object obj) {
        if(this.otherField == null) {
            this.otherField = new ConcurrentHashMap();
        }

        this.otherField.put(key, obj);
    }

    public void removeField(String key) {
        this.otherField.remove(key);
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getDataCount() {
        return this.dataCount;
    }

    public List getData() {
        return this.data;
    }

    public Map<String, Object> getOtherField() {
        return this.otherField;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public void setOtherField(Map<String, Object> otherField) {
        this.otherField = otherField;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof PageDto)) {
            return false;
        } else {
            PageDto other = (PageDto)o;
            if(!other.canEqual(this)) {
                return false;
            } else if(this.getPageIndex() != other.getPageIndex()) {
                return false;
            } else if(this.getPageSize() != other.getPageSize()) {
                return false;
            } else if(this.getDataCount() != other.getDataCount()) {
                return false;
            } else {
                List this$data = this.getData();
                List other$data = other.getData();
                if(this$data == null) {
                    if(other$data != null) {
                        return false;
                    }
                } else if(!this$data.equals(other$data)) {
                    return false;
                }

                Map this$otherField = this.getOtherField();
                Map other$otherField = other.getOtherField();
                if(this$otherField == null) {
                    if(other$otherField != null) {
                        return false;
                    }
                } else if(!this$otherField.equals(other$otherField)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageDto;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        int result1 = result * 59 + this.getPageIndex();
        result1 = result1 * 59 + this.getPageSize();
        result1 = result1 * 59 + this.getDataCount();
        List $data = this.getData();
        result1 = result1 * 59 + ($data == null?43:$data.hashCode());
        Map $otherField = this.getOtherField();
        result1 = result1 * 59 + ($otherField == null?43:$otherField.hashCode());
        return result1;
    }

    public String toString() {
        return "PageDto(pageIndex=" + this.getPageIndex() + ", pageSize=" + this.getPageSize() + ", dataCount=" + this.getDataCount() + ", data=" + this.getData() + ", otherField=" + this.getOtherField() + ")";
    }
}
