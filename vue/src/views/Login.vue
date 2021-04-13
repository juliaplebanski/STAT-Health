<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 id="sign-in-title">Sign In</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password. Please try again.
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering. Please sign in.
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control-login"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control-login"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <p>
        <button type="submit" id="submit">Sign in</button>
      </p>
      <p id="sign-in">New Patient?</p>
      <router-link :to="{ name: 'register' }" id="register"
        >Create Account</router-link
      >
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/home");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
<style>
#sign-in-title {
  color: #1e3250;
  margin: 100px 20px 20px 20px;
}


#submit {
  border: 1px solid #e3e8ed;
  color: #1e3250;
  background-color: #cdeaec;
  padding: 5px 30px 5px 30px;
  font-size: 1.1em;
}
#register {
  border: 1px solid #e3e8ed;
  color: #1e3250;
  background-color: #cdeaec;
  padding: 10px 30px 10px 30px;
  font-size: 1.1em;
}
#register {
  text-decoration: none;
}
#submit:hover,
#register:hover {
  background-color: #57babf;
}
#sign-in {
  margin: 20px 0px 20px 0px;
  color: #1e3250;
}
input {
  size: 400px;
}
input[type="text"],
input[type="password"] {
  width: 51%;
  padding: 10px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: 1px solid #e3e8ed;
  border-radius: 10px;
  background: white;
}
</style>