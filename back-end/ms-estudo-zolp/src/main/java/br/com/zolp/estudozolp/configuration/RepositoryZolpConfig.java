package br.com.zolp.estudozolp.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jndi.JndiTemplate;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//import java.util.Properties;
//
///**
// * Classe responsavel por efetuar a configuracao do repositorio.
// *
// * @author mamede
// * @version 0.0.1-SNAPSHOT
// */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//    basePackages = "br.com.zolp.estudozolp.repository",
//    entityManagerFactoryRef = "repositoryZolpEntityManager",
//    transactionManagerRef = "repositoryZolpTransactionManager"
//)
//@PropertySource({"classpath:database.properties"})
public class RepositoryZolpConfig {

//    @Autowired
//    private Environment env;
//
//    /**
//     * Efetua a configuração do DataSource com base no \"Jndi Name\" configurado no
//     * servidor de aplicações. A implementação do método deverá ser anotada como
//     * \"@Bean\" para que o mesmo possa ser inicializado pelo Spring.
//     *
//     * Caso seja necessário utilizar multiplos repositórios (dataSources), a
//     * implementação deste método deverá ser anotada ao menos em uma implementação,
//     * com a anotação \"@Primary\".
//     *
//     * @return
//     * @throws NamingException
//     */
//    @Bean(name = "repositoryZolpDataSource", destroyMethod = "")
//    public DataSource repositoryZolpDataSource() throws NamingException {
//
//        final JndiTemplate jndi = new JndiTemplate();
//        final DataSource dataSource = jndi.lookup(env.getRequiredProperty("hibernate.connection.datasource"),
//                                                  DataSource.class);
//        return dataSource;
//
//    }
//
//    /**
//     * Efetua a configuração do entityManger. Caso seja necessário utilizar
//     * multiplos repositórios (dataSources), a implementação deste método deverá ser
//     * anotada ao menos em uma implementação, com a anotação \"@Primary\".
//     *
//     * @return
//     * @throws NamingException
//     */
//    @Bean
//    public LocalContainerEntityManagerFactoryBean repositoryZolpEntityManager() throws NamingException {
//
//        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//
//        em.setDataSource(this.repositoryZolpDataSource());
//        em.setPackagesToScan(new String[] {"br.com.zolp.estudozolp.entity"});
//        em.setPersistenceUnitName("repositoryZolpJpaPersistenceUnit");
//
//        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//
//        em.setJpaProperties(hibernateProperties());
//
//        return em;
//    }
//
//    /**
//     * Efetua a configuração do transactionManager Caso seja necessário utilizar
//     * multiplos repositórios (dataSources), a implementação deste método deverá ser
//     * anotada ao menos em uma implementação, com a anotação \"@Primary\".
//     *
//     * @return
//     * @throws NamingException
//     */
//    @Bean
//    public PlatformTransactionManager repositoryZolpTransactionManager() throws NamingException {
//
//        final JpaTransactionManager transactionManager = new JpaTransactionManager();
//
//        transactionManager.setEntityManagerFactory(repositoryZolpEntityManager().getObject());
//
//        return transactionManager;
//    }
//
//    /**
//     * Preenche as propriedades utilizadas no hibernate com base no arquivo de
//     * configurações da aplicação.
//     *
//     * @return
//     */
//    private Properties hibernateProperties() {
//
//        final Properties properties = new Properties();
//
//        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
//        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
//        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
//
//        return properties;
//    }

}
