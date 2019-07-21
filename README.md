# spring-boot-okta

Using authentication with Spring Boot, OAuth2 and Okta

**Prerequisites:** Java 8

> [Okta](https://developer.okta.com/) has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage, and secure users and roles in any application.
> To run the `spring-boot-okta` example, you'll need to create an account and OIDC app on Okta.

### Create an Application in Okta

Log in to your Okta Developer account (or [sign up](https://developer.okta.com/signup/) if you don’t have an account).

1. From the **Applications** page, choose **Add Application**.
2. On the Create New Application page, select **Web**.
3. Give your app a memorable name, add `http://localhost:8080/login/oauth2/code/okta` as a Login redirect URI, then click **Done**.

Copy your issuer (found under **API** > **Authorization Servers**), client ID, and client secret into `oauth-okta-starter/src/main/resources/application.yml` as follows:

```yaml
okta:
    oauth2:
        issuer: https://{yourOktaDomain}/oauth2/default
        client-id: { yourClientID }
        client-secret: { yourClientSecret }
```

**NOTE:** The value of `{yourOktaDomain}` should be something like `dev-123456.okta.com`. Make sure you don't include `-admin` in the value!

After modifying this file, you should be able to authenticate with Okta at `http://localhost:8080/profile`.

## Links

This example uses the following open source libraries:

-   [Okta Spring Boot Starter](https://github.com/okta/okta-spring-boot)
-   [Spring Boot](https://spring.io/projects/spring-boot)
-   [Spring Security](https://spring.io/projects/spring-security)
-   [OpenJDK](https://openjdk.java.net/)
