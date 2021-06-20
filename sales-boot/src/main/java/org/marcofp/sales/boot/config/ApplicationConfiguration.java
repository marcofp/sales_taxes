package org.marcofp.sales.boot.config;

import org.marcofp.sales.service.SalesApi;

/**
 * The application configuration interface.
 *
 * @author <a href="mailto:marcofp@gmail.com">Marco Fuentelsaz</a>
 * @since 1.0.0
 */
public interface ApplicationConfiguration {

    /**
     * Gets the API instance.
     *
     * @return the API instance.
     */
    SalesApi getSalesAPI();
}
