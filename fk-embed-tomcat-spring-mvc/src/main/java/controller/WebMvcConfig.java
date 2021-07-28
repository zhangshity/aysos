package controller;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc//若无此注解，WebMvcConfigurerAdapter无效
@ComponentScan("controller")//自动扫描spring注解 比如@Service、@Component、@Repository和@Controller的类，并注册为Bean
@Configuration//声明当前类是一个配置类（类似于 spring_xxx.xml 的文件）
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//    //添加一个ViewResolver解析view
//    @Bean//相当于Spring配置文件bean节点
//    public InternalResourceViewResolver viewResolver(){
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        viewResolver.setViewClass(JstlView.class);
//        return viewResolver;
//    }
//
//    //注册静态资源，没注册的话，网站是访问不了的
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
//        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
//        registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/fonts/");
//    }
//
//    //根目录的时候直接跳转到登录界面
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("Login");
//    }
}