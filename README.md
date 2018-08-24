# TLM UI BFF

## Generate api and models from swagger file

```bash
java -jar swagger-codegen-cli-2.3.1.jar generate \
  -i https://todo-management.cm.tm.kit.edu/v2/api-docs \
  -l spring --library spring-cloud \
  -o tlm-ui-bff/ \
  -c swagger-codegen.json \
  -Dmodels -Dapis
```