import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainPrueba {
    public static void main(String[] args) {
        EntityManagerFactory mf = Persistence.createEntityManagerFactory("CRUDProductosHibernate");
        EntityManager em = mf.createEntityManager();
    }
}
