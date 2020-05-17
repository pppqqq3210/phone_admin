package com.hopu.phone_admin.entity;

import lombok.Data;

import java.util.List;

/**
 * TreeView中的节点
 */
@Data
public class ModuleTreeNode {

    public static class State{
        private boolean checked;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }
    }
    private State state = new State();

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    private String text;
    private String href;
    private List<ModuleTreeNode> nodes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<ModuleTreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<ModuleTreeNode> nodes) {
        this.nodes = nodes;
    }
}
