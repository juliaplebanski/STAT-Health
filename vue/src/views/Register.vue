<template>
  <div>
    <the-header />
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="create-account">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control-register"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control-register"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control-register"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <p>
        <router-link :to="{ name: 'login' }" id="register-link"
          >Have an account?</router-link
        >
      </p>
      <button class="submit-button" type="submit">Create Account</button>
    </form>
  </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import TheHeader from '../components/TheHeader.vue';

export default {
  name: "register",
  components: {
    TheHeader
  },
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style>
.create-account {
  color: #1e3250;
  margin: 100px 20px 20px 20px;
}
.text-center {
  justify-content: center;
  border: 1px solid #dfdfdf;
  border-radius: 10px;
  background-color: #f5f4f4;
  display: block;
  margin: 20px 400px 200px 400px;
  text-decoration: none;
}
.submit-button {
  border: 1px solid #e3e8ed;
  color: #1e3250;
  background-color: #cdeaec;
  padding: 10px 30px 10px 30px;
  font-size: 1.1em;
}
.submit-button:hover {
  background-color: #46a7ad;
  color: white;
}
#register-link {
  color: #1e3250;
  text-decoration: underline;
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