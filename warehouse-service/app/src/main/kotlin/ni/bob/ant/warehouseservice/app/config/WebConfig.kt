package ni.bob.ant.warehouseservice.app.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan(basePackages = ["ni.bob.ant.warehouseservice.usecase.usecase"])
@Configuration
class WebConfig