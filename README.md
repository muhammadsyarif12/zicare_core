
# ZiCare Core

Aplikasi ini dibuat untuk memenuhi tahap tecnical test dari ZiCare (BackEnd).
Menggunakan framework Java Springboot.



## Features
Rest API untuk :
- Login
- Signup
- Get Profile


## API Reference

#### Login

```http
  POST /api/v1/auth/login
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `string` | **Required**. Username harus diisi |
| `password` | `string` | **Required**. Password harus diisi |

_RESPONSE: menghasilkan token_

#### SignUp

```http
  POST /api/v1/auth/signup
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `string` | **Required**. Username harus diisi |
| `full_name`      | `string` | **Required**. Full Name harus diisi |
| `email`      | `string` | **Required**. Email harus diisi |
| `password`      | `string` | **Required**. Password harus diisi |

```http
  GET /api/v1/users/me
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization`      | `string` | **Required**. Token Bearer |




## Screenshoots

- Login API

![image](https://github.com/muhammadsyarif12/zicare_core/assets/47375550/0af8d7ad-86f7-40e5-9d7f-0994d1297a17)


- SignUp API

![image](https://github.com/muhammadsyarif12/zicare_core/assets/47375550/36ab1fd9-9475-4398-8ff0-79efc9305ed5)


- Get Profile API

![image](https://github.com/muhammadsyarif12/zicare_core/assets/47375550/3fcc1a73-dea5-4941-848b-21e367a95fab)


## Tech Stack

**Tech:** Java Springboot, jwt

**Database:** MySQL

