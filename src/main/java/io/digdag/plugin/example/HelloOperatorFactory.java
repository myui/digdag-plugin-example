package io.digdag.plugin.example;

import io.digdag.client.config.Config;
import io.digdag.spi.Operator;
import io.digdag.spi.OperatorFactory;
import io.digdag.spi.TaskExecutionContext;
import io.digdag.spi.TaskRequest;
import io.digdag.spi.TaskResult;
import io.digdag.spi.TemplateEngine;
import io.digdag.util.BaseOperator;

import java.nio.file.Path;

public class HelloOperatorFactory implements OperatorFactory {
    @SuppressWarnings("unused")
    private final TemplateEngine templateEngine;

    public HelloOperatorFactory(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public String getType() {
        return "hello";
    }

    @Override
    public Operator newOperator(Path projectPath, TaskRequest request) {
        return new HelloOperator(projectPath, request);
    }

    private class HelloOperator extends BaseOperator {

        HelloOperator(Path projectPath, TaskRequest request) {
            super(projectPath, request);
        }

        @Override
        public TaskResult runTask(TaskExecutionContext ctx) {
            //Config params = request.getConfig();
            Config params = request.getConfig().mergeDefault(
                request.getConfig().getNestedOrGetEmpty("hello"));

            String message = params.get("_command", String.class);
            message += params.get("message", String.class);

            System.out.println(message);

            return TaskResult.empty(request);
        }

    }
}
