
package org.mule.modules.ubercon.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.ubercon.UberConConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>UberConConnectorProcessAdapter</code> is a wrapper around {@link UberConConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-09-13T02:14:48-07:00", comments = "Build UNNAMED.2793.f49b6c7")
public abstract class UberConConnectorProcessAdapter
    extends UberConConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<UberConConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, UberConConnectorCapabilitiesAdapter> getProcessTemplate() {
        final UberConConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,UberConConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, UberConConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, UberConConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
