package com.wso2.custom.usermgt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.wso2.carbon.user.api.RealmConfiguration;
import org.wso2.carbon.user.core.UserRealm;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.claim.ClaimManager;
import org.wso2.carbon.user.core.jdbc.JDBCUserStoreManager;
import org.wso2.carbon.user.core.profile.ProfileConfigurationManager;

import java.util.Map;

public class CustomUserStoreManager extends JDBCUserStoreManager{

    private static Log log = LogFactory.getLog(CustomUserStoreManager.class);

    private static StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

    public CustomUserStoreManager(RealmConfiguration realmConfig, Map<String, Object> properties, ClaimManager claimManager, ProfileConfigurationManager profileManager, UserRealm realm, Integer tenantId) throws UserStoreException{
        super(realmConfig, properties, claimManager, profileManager, realm, tenantId);
    }

    @Override
    public void doSetUserClaimValue(String userName, String claimURI, String claimValue, String profileName) throws UserStoreException {
        System.out.println("doSetUserClaimValue operation is called");
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

    @Override
    public void doSetUserClaimValues(String userName, Map<String, String> claims, String profileName) throws UserStoreException {
        System.out.println("doSetUserClaimValues operation is called");
        throw new UserStoreException("User store is operating in read only mode. Cannot write into the user store.");
    }

}
