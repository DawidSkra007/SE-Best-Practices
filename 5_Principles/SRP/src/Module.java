package src;

public class Module {
    private String moduleName;
    private String moduleCode;

    public Module(String moduleName, String moduleCode) {
        this.moduleName = moduleName;
        this.moduleCode  = moduleCode;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", moduleCode, moduleName);
    }
}

