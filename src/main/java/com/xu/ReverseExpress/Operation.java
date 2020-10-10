package com.xu.ReverseExpress;

@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
public enum Operation {

    add('+',1),
    subtract('-',1),
    multiply('*',2),
    divede('/',2),
    equals('=',0);


    private Character character;

    private Integer priority;

    Operation(Character character, Integer priority) {
        this.character = character;
        this.priority = priority;
    }

    public static Operation  parseChar(char c){
        for (Operation value : Operation.values()) {
            if(value.character.equals(c)) {
                return value;
            }
        }
        return null;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
