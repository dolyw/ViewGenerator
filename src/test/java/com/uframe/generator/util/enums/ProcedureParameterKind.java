package com.uframe.generator.util.enums;

public enum ProcedureParameterKind
{
    NORMAL("NORMAL", 0, "NORMAL", "\u666e\u901a"), 
    ARRAY("ARRAY", 1, "ARRAY", "\u6570\u7ec4"), 
    CURSOR("CURSOR", 2, "CURSOR", "\u6e38\u6807");
    
    private String id;
    private String name;
    
    private ProcedureParameterKind(final String s, final int n, final String id, final String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
}
