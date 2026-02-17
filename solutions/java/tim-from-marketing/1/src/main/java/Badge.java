class Badge {
    public String print(Integer id, String name, String department) {

        String idPrefix = (id == null) ? "" : "[" + id + "] - ";

        String deptSuffix = (department == null) ? "OWNER" : department.toUpperCase();

        return idPrefix + name + " - " + deptSuffix;
    }
}
