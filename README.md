###

Requirements:

1. Run Cassandra: in "/dockers" `docker-compose` up OR `docker run -it --rm -p 9042:9042 cassandra`
2. Set up `dev` keyspace:
   * `docker exec -it dockers_cassandra_1 bash`
   * Cassandra Query Language Shell: `cqlsh`
   * Check if dev schema is there: `SELECT * FROM system_schema.keyspaces;` 
   * `create keyspace dev with replication =  {'class':'SimpleStrategy', 'replication_factor':1};`
3. 