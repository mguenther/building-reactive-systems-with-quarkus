package net.mguenther.reactive.employee;

import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeIndexer {

    private static final Logger LOG = Logger.getLogger(EmployeeIndexer.class);

    @Incoming("employee-events")
    @Blocking
    public void processEvent(final EmployeeEvent event) {
        if (event instanceof EmployeeCreatedEvent) {
            processEvent((EmployeeCreatedEvent) event);
        } else if (event instanceof EmployeeDeletedEvent) {
            processEvent((EmployeeDeletedEvent) event);
        }
    }

    private void processEvent(final EmployeeCreatedEvent event) {
        LOG.info("Received an EmployeeCreatedEvent: " + event.getEmployeeId());
    }

    private void processEvent(final EmployeeDeletedEvent event) {
        LOG.info("Received an EmployeeDeletedEvent: " + event.getEmployeeId());
    }
}
