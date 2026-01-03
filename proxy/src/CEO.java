public class CEO implements Leader {
    
    /**
     * Signs a document with the CEO's authorization.
     */
    @Override
    public void signDocument(String documentName) {
        System.out.println("CEO signed the document: " + documentName);
    }
    
}
