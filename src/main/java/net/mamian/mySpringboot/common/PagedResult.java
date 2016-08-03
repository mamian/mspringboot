/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.common;

import java.util.List;

/**
 * 
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-8-3 15:56:18
 * @copyright ©2016 马面 All Rights Reserved
 */
public class PagedResult<T> extends BaseObject {

    private static final long serialVersionUID = 20131015L;

    private List<T> results;

    private long totalSize;

    public PagedResult() {
    }

    public PagedResult(List<T> results,
                       long totalSize) {
        this.results = results;
        this.totalSize = totalSize;
    }

    public List<T> getResults() {
        return results;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
    
}