package ni.bob.ant.orderservice.app.conf

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan(basePackages = ["ni.bob.ant.orderservice.usecase.usecase"])
@Configuration
class WebConfig