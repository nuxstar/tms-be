package com.flyers.tms.config;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *The blobServiceClient method is annotated with @Bean to create a bean of type BlobServiceClient,
 *  which will be used for interacting with Azure Blob Storage.
 *  The connection string is constructed using the account name and account key,
 *  and then the BlobServiceClient is created using the BlobServiceClientBuilder.
 */
@Configuration
public class AzureStorageConfig {

  @Value("${azure.storage.account-name}")
  private String accountName;

  @Value("${azure.storage.account-key}")
  private String accountKey;

  /**
   * Blocb service client.
   *
   * @return blob instance
   */
  @Bean
  public BlobServiceClient blobServiceClient() {
    String connectionString = String.format(
        "DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s;"
            + " EndpointSuffix=core.windows.net", accountName, accountKey);
    return new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
  }
}
