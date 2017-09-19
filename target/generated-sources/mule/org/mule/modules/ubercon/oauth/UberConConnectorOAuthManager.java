
package org.mule.modules.ubercon.oauth;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.api.expression.ExpressionManager;
import org.mule.api.store.ObjectStore;
import org.mule.modules.ubercon.UberConConnector;
import org.mule.modules.ubercon.adapters.UberConConnectorOAuth2Adapter;
import org.mule.modules.ubercon.config.ConnectorConfig;
import org.mule.security.oauth.BaseOAuth2Manager;
import org.mule.security.oauth.OAuth2Adapter;
import org.mule.security.oauth.OAuth2Manager;
import org.mule.security.oauth.OnNoTokenPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A {@code UberConConnectorOAuthManager} is a wrapper around {@link UberConConnector } that adds access token management capabilities to the pojo.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-09-13T02:14:48-07:00", comments = "Build UNNAMED.2793.f49b6c7")
public class UberConConnectorOAuthManager
    extends BaseOAuth2Manager<OAuth2Adapter>
{

    private static Logger logger = LoggerFactory.getLogger(UberConConnectorOAuthManager.class);

    @Override
    protected Logger getLogger() {
        return logger;
    }

    /**
     * Sets greeting
     * 
     * @param scope to set
     */
    public void setGreeting(String value) {
        UberConConnectorOAuth2Adapter connector = ((UberConConnectorOAuth2Adapter) this.getDefaultUnauthorizedConnector());
        ((ConnectorConfig) connector.getConfig()).setGreeting(value);
    }

    /**
     * Retrieves greeting
     * 
     */
    public String getGreeting() {
        UberConConnectorOAuth2Adapter connector = ((UberConConnectorOAuth2Adapter) this.getDefaultUnauthorizedConnector());
        return ((ConnectorConfig) connector.getConfig()).getGreeting();
    }

    /**
     * Sets reply
     * 
     * @param scope to set
     */
    public void setReply(String value) {
        UberConConnectorOAuth2Adapter connector = ((UberConConnectorOAuth2Adapter) this.getDefaultUnauthorizedConnector());
        ((ConnectorConfig) connector.getConfig()).setReply(value);
    }

    /**
     * Retrieves reply
     * 
     */
    public String getReply() {
        UberConConnectorOAuth2Adapter connector = ((UberConConnectorOAuth2Adapter) this.getDefaultUnauthorizedConnector());
        return ((ConnectorConfig) connector.getConfig()).getReply();
    }

    /**
     * Sets consumerKey
     * 
     * @param key to set
     */
    public void setConsumerKey(String value) {
        super.setConsumerKey(value);
    }

    /**
     * Sets consumerSecret
     * 
     * @param secret to set
     */
    public void setConsumerSecret(String value) {
        super.setConsumerSecret(value);
    }

    @Override
    protected OAuth2Adapter instantiateAdapter() {
        return new org.mule.modules.ubercon.adapters.UberConConnectorRestClientAdapter(this);
    }

    @Override
    protected KeyedPoolableObjectFactory createPoolFactory(OAuth2Manager<OAuth2Adapter> oauthManager, ObjectStore<Serializable> objectStore) {
        return new UberConConnectorOAuthClientFactory(oauthManager, objectStore);
    }

    @Override
    protected void setCustomProperties(OAuth2Adapter adapter) {
        UberConConnectorOAuth2Adapter connector = ((UberConConnectorOAuth2Adapter) adapter);
        ((ConnectorConfig) connector.getConfig()).setGreeting(getGreeting());
        ((ConnectorConfig) connector.getConfig()).setReply(getReply());
        ((ConnectorConfig) connector.getConfig()).setConsumerKey(getConsumerKey());
        ((ConnectorConfig) connector.getConfig()).setConsumerSecret(getConsumerSecret());
    }

    protected void fetchCallbackParameters(OAuth2Adapter adapter, String response) {
        UberConConnectorOAuth2Adapter connector = ((UberConConnectorOAuth2Adapter) adapter);
        ExpressionManager expressionManager = (muleContext.getExpressionManager());
        MuleMessage muleMessage = new DefaultMuleMessage(response, (muleContext));
    }

    public void setOnNoToken(OnNoTokenPolicy policy) {
        this.getDefaultUnauthorizedConnector().setOnNoTokenPolicy(policy);
    }

    @Override
    protected Set<Class<? extends Exception>> refreshAccessTokenOn() {
        Set<Class<? extends Exception>> types = new HashSet<Class<? extends Exception>>();
        types.add(Exception.class);
        return types;
    }

}
