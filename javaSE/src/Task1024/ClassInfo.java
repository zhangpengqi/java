package Task1024;

/**
 * 班级信息
 */
public class ClassInfo {
    int classId;//班级id
    String className;//班级名称

    public ClassInfo() {
    }

    public ClassInfo(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
