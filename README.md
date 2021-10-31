# finalism
An overengineered URL shortener

![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)
![SASS](https://img.shields.io/badge/SASS-hotpink.svg?style=for-the-badge&logo=SASS&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Redis](https://img.shields.io/badge/redis-%23DD0031.svg?style=for-the-badge&logo=redis&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

## UI
![flsm_ss_1](https://user-images.githubusercontent.com/77390780/139129590-a57dc748-5689-4afa-9bd1-1406adb442e9.png)

## How to run locally
#### Prequisites: Docker (https://www.docker.com/)
1. Download/clone the release branch of this repository
2. Inside the finalism-server directory, create a file named .env with the following info:
```
FLSM_POSTGRES_DATASOURCE_URL=jdbc:postgresql://postgres-db:<port>/
FLSM_POSTGRES_DATASOURCE_USER=
FLSM_POSTGRES_DATASOURCE_PASS=
FLSM_REDIS_CACHE_NAME=
FLSM_REDIS_PORT=
FLSM_REDIS_HOST=
POSTGRES_PASSWORD=
```
3. Inside the finalism-client directory, create a file named .env with the following info:
```
REACT_APP_API_URL=http://localhost:8080
```
4. Launch a terminal and enter the following command:
```
docker-compose up
```
Note: first time docker build will take a couple of minutes, subsequent runs will be much faster

5. Access the client at http://localhost:3000/ once all the services have been started
