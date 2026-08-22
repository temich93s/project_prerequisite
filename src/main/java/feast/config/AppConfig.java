package feast.config;

import feast.models.Chicken3;
import feast.models.Duck2;
import feast.models.Goat6;
import feast.models.Lamb5;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "feast")
public class AppConfig {
    @Bean
    public static Duck2 getDuck(Chicken3 chicken) {
        return new Duck2(chicken);
    }

    @Bean
    public static Lamb5 lamb5(Goat6 goat) {
        return new Lamb5(goat);
    }
}
