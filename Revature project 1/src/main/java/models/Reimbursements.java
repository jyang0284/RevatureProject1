package models;

import java.util.Date;

public class Reimbursements {

        private Integer id;
        private Integer amount;
        private String description;
        private String receipt;
        private Integer author;
        private Integer resolver;
        private Integer status;
        private Integer type;
        private Date submitted;



        //These are my three constructors:
        //1.
        public Reimbursements(int anInt) {
        }
        //2.
        public Reimbursements(Integer id, Integer amount, String description, String receipt, Integer author, Integer resolver, Integer status, Integer type, Date submitted) {
            this.id = id;
            this.amount = amount;
            this.description = description;
            this.receipt = receipt;
            this.author = author;
            this.resolver = resolver;
            this.status = status;
            this.type = type;
            this.submitted = submitted;
        }
        //3.
        public Reimbursements(String description, String receipt) {
            this.description = description;
            this.receipt = receipt;
        }

        //4. This constructor allows for usrs (Managers) to change the status ID of a reimbursement request
    public Reimbursements(Integer status, Integer id) {
        this.status = status;
        this.id = id;}


    //5.

        public Reimbursements(Integer id, Integer amount, Integer author, Integer status, Integer type, Date submitted) {
            this.id = id;
            this.amount = amount;
            this.author = author;
            this.status = status;
            this.type = type;
            this.submitted = submitted;
        }

    public Reimbursements() {

    }

    // These are my getters/Setters below:

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getReceipt() {
            return receipt;
        }

        public void setReceipt(String receipt) {
            this.receipt = receipt;
        }

        public Integer getAuthor() {
            return author;
        }

        public void setAuthor(Integer author) {
            this.author = author;
        }

        public Integer getResolver() {
            return resolver;
        }

        public void setResolver(Integer resolver) {
            this.resolver = resolver;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Date getSubmitted() {
            return submitted;
        }

        public void setSubmitted(Date submitted) {
            this.submitted = submitted;
        }

        // This is my toString method
        @Override
        public String toString() {
            return "reimbursement{" +
                    "id=" + id +
                    ", amount=" + amount +
                    ", description='" + description + '\'' +
                    ", receipt=" + receipt +
                    ", author=" + author +
                    ", resolver=" + resolver +
                    ", status=" + status +
                    ", type=" + type +
                    ", submitted=" + submitted +
                    '}';
        }
    }
