package builder;

public class QueryBuilder {

    private String select;
    private String from;
    private String where;
    private String and;
    private String or;
    private String igual;
    private String count;
    private String alias;
    private String leftJoin;
    private String innerJoin;

    public static class Builder {

        private String select = "";
        private String from = "";
        private String where = "";
        private String and = "";
        private String or = "";
        private String igual = "";
        private String count = "";
        private String alias = "";
        private String leftJoin = "";
        private String innerJoin = "";


        public Builder() {
            this.select = " SELECT ";
        }

        public Builder from(String tabela) {
            this.from = " FROM " + tabela + " ";
            return this;
        }

        public Builder where(String parametro) {
            this.where = " WHERE 1 = 1" + this.and(parametro);
            return this;
        }

        public Builder and( String parametro) {
            this.and = " AND ";
            return this;
        }

        public Builder or(String parametro) {
            this.or = " OR ";
            return this;
        }

        public Builder igual( String parametro) {
            this.igual = " = ";
            return this;
        }

        public Builder count() {
            this.count = " COUNT ";
            return this;
        }

        public Builder alias(String alias) {
            this.alias = alias;
            return this;
        }

        public Builder leftJoin() {
            this.leftJoin = " LEFT JOIN ";
            return this;
        }

        public Builder innerJoin(String alias) {
            this.innerJoin = " INNER JOIN " + alias;
            return this;
        }

        public QueryBuilder build() {
            return new QueryBuilder(this);
        }
    }

    public QueryBuilder(Builder builder) {
        select = builder.select;
        from = builder.from;
        where = builder.where;
        and = builder.and;
        or = builder.or;
        igual = builder.igual;
        count = builder.count;
        alias = builder.alias;
        leftJoin = builder.leftJoin;
        innerJoin = builder.innerJoin;
    }

	@Override
	public String toString() {
		return "QueryBuilder [select=" + select + ", from=" + from + ", where=" + where + ", and=" + and + ", or=" + or
				+ ", igual=" + igual + ", count=" + count + ", alias=" + alias + ", leftJoin=" + leftJoin
				+ ", innerJoin=" + innerJoin + "]";
	}
    
    

}
