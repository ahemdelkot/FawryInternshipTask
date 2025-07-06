package Products;

import java.time.LocalDate;

public abstract class ExpirableProduct extends Product {
    LocalDate expirationDate;
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
}
