package cn.chineseall.model.book.vo;

import java.util.List;

import cn.chineseall.model.BaseEntity;

public class DirectoryNode extends BaseEntity {

    public DirectoryNode() {
    }

    public DirectoryNode(String nodeId, String nodeName, Integer page) {
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.page = page;
    }

    private String nodeId;

    private String nodeName;

    private Integer page;

    private List<DirectoryNode> childNodes;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<DirectoryNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<DirectoryNode> childNodes) {
        this.childNodes = childNodes;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
