# TLM UI BFF

## Generate api and models from swagger file
When a microservice changes the client interfaces have to be updated with the following command after deleting the old ones:
```bash
java -jar swagger-codegen-cli-2.3.1.jar generate \
  -i https://todo-management.cm.tm.kit.edu/v2/api-docs \
  -l spring --library spring-cloud \
  -o . \
  -c swagger-codegen.json \
  -Dmodels -Dapis
```
After the code is generated, every DTO with non-optional fields (usually `Create`- and `UpdateRequests`) has to be annotated with `@JsonInclude`.
Additionally, unused Apis and ApiClients should be removed and the invalid imports and possibly the microservice URL in the client have to be fixed.