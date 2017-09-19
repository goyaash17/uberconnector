
package org.mule.modules.ubercon.oauth;

import java.io.Serializable;
import javax.annotation.Generated;
import org.mule.api.store.ObjectStore;
import org.mule.common.security.oauth.OAuthState;
import org.mule.modules.ubercon.adapters.UberConConnectorOAuth2Adapter;
import org.mule.modules.ubercon.config.ConnectorConfig;
import org.mule.security.oauth.BaseOAuthClientFactory;
import org.mule.security.oauth.OAuth2Adapter;
import org.mule.security.oauth.OAuth2Manager;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-09-13T02:14:48-07:00", comments = "Build UNNAMED.2793.f49b6c7")
public class UberConConnectorOAuthClientFactory
    extends BaseOAuthClientFactory
{

    private UberConConnectorOAuthManager oauthManager;

    public UberConConnectorOAuthClientFactory(OAuth2Manager<OAuth2Adapter> oauthManager, ObjectStore<Serializable> objectStore) {
        super(oauthManager, objectStore);
        this.oauthManager = (UberConConnectorOAuthManager) oauthManager;
    }

    @Override
    protected Class<? extends OAuth2Adapter> getAdapterClass() {
        return (org.mule.modules.ubercon.adapters.UberConConnectorRestClientAdapter.class);
    }

    @Override
    protected void setCustomAdapterProperties(OAuth2Adapter adapter, OAuthState state) {
        UberConConnectorOAuth2Adapter connector = ((UberConConnectorOAuth2Adapter) adapter);
        ((ConnectorConfig) connector.getConfig()).setGreeting(oauthManager.getGreeting());
        ((ConnectorConfig) connector.getConfig()).setReply(oauthManager.getReply());
    }

    @Override
    protected void setCustomStateProperties(OAuth2Adapter adapter, OAuthState state) {
        UberConConnectorOAuth2Adapter connector = ((UberConConnectorOAuth2Adapter) adapter);
    }

}
