public class Secretary implements Leader {
    
    private CEO ceo;

    public Secretary(CEO ceo) {
        this.ceo = ceo;
    }

    /**
     * Signs a document if it's not marked as important; otherwise, forwards it to the CEO.
     */
    @Override
    public void signDocument(String documentName) {
        if (documentName == null || documentName.isEmpty()) {
            System.out.println("Secretary: Document name is invalid. Cannot sign.");
            return;
        }

        if (documentName.contains("[IMPORTANT]")) {
            System.out.println("Secretary: Document is important. Forwarding to CEO for signature.");
            ceo.signDocument(documentName);
        } else {
            System.out.println("Secretary signed the document: " + documentName);
        }
    }

}
