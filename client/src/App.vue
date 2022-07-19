<!DOCTYPE html>
<head>
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
/>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<template>
  <div id="app">
    <div class ="card">
      <div class = "card-header text-left">
        <h4>chatting</h4>
      </div>
      <div class = "card-body">

        <div role = "alert" class="alert text-left alert-info">
          <!-- alert-success, alert-warning, alert-danger, alert-primary-->
          <span>message</span>
        </div>


          <div role = "alert" class="alert text-left alert-info"
              v-for="(item, idx) in recvList"
              :key="idx"
          >
            <h3 class="alert-info-username"> {{ item.userName }}</h3>
            <h3 class="alert-info2">{{ item.userMessage }}</h3>
          </div>
        </div>

      </div>

    </div>
    <div class = "input_message">
    <span> 유저이름: </span>
    <input class="input_name"
        v-model="userName"
        type="text"
    >

    <span> 내용: </span>
      <input class="input_content"
      v-model="message"
      type="text"
      @keyup="sendMessage"
  >
      </div>

</template>

<script>
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'

export default {
  name: 'App',
  data() {
    return {
      userName: "",
      message: "",
      recvList: []
    }
  },
  created() {
    // App.vue가 생성되면 소켓 연결을 시도합니다.
    this.connect()
  },
  methods: {
    sendMessage (e) {
      if(e.keyCode === 13 && this.userName !== '' && this.message !== ''){
        this.send()
        this.message = ''
      }
    },
    send() {
      console.log("Send message:" + this.message);
      if (this.stompClient && this.stompClient.connected) {
        const msg = {
          userName: this.userName,
          userMessage: this.message
        };
        this.stompClient.send("/receive", JSON.stringify(msg), {});
        // this.stompClient.send("http://localhost:8080/group_chat/insert", JSON.stringify(msg), {});
      }
    },
    connect() {
      const serverURL = "http://localhost:8080"
      let socket = new SockJS(serverURL);
      this.stompClient = Stomp.over(socket);
      console.log(`소켓 연결을 시도합니다. 서버 주소: ${serverURL}`)
      this.stompClient.connect(
          {},
          frame => {
            // 소켓 연결 성공
            this.connected = true;
            console.log('소켓 연결 성공', frame);
            // 서버의 메시지 전송 endpoint를 구독합니다.
            // 이런형태를 pub sub 구조라고 합니다.
            this.stompClient.subscribe("/send", res => {
              console.log('구독으로 받은 메시지 입니다.', res.body);

              // 받은 데이터를 json으로 파싱하고 리스트에 넣어줍니다.
              this.recvList.push(JSON.parse(res.body))
            });
          },
          error => {
            // 소켓 연결 실패
            console.log('소켓 연결 실패', error);
            this.connected = false;
          }
      );
    }

  }
}
</script>
<style>


.alert{position:relative;padding:.9rem 1.25rem;margin-bottom:1rem;border:.0625rem solid transparent;border-radius:.2857rem}.alert-heading{color:inherit}
.alert-link{font-weight:600}
.alert-dismissible{padding-right:3.8125rem}
.alert-dismissible
.close{position:absolute;top:0;right:0;padding:.9rem 1.25rem;color:inherit}
.alert-primary{color:#e14eca;background-color:#e66ad2;border-color:#e66ad2}
.alert-primary hr{border-top-color:#e254cb}
.alert-primary .alert-link{color:#d725bb}.alert-secondary{color:#f4f5f7;background-color:#f6f7f8;border-color:#f6f7f8}
.alert-secondary hr{border-top-color:#e8eaed}
.alert-secondary .alert-link{color:#d6dae2}.alert-success{color:#00f2c3;background-color:#29f4cd;border-color:#29f4cd}
.alert-success hr{border-top-color:#11f3c7}
.alert-success .alert-link{color:#00bf9a}
.alert-info{color:#1d8cf8;background-color:#419ef9;border-color:#419ef9}
.alert-info2{color:#1d8cf8;background-color:#ffffff;border-color:#419ef9;
  text-align: left;
  border-radius:.2857rem;
  padding:.9rem 1.25rem;
}
.alert-info-username{color:#1d8cf8;background-color:#ffffff;border-color:#419ef9;
  max-width: 10.66667%;
  text-align: center;
  padding:.25rem .25rem;
  border-radius:.2857rem

}
.alert-info hr{border-top-color:#2891f8}
.alert-info .alert-link{color:#0772db;
  text-align: left;
  border-radius:.2857rem;
  padding:.9rem 1.25rem;
}
.alert-warning{color:#ff8d72;background-color:#ff9f89;border-color:#ff9f89}
.alert-warning hr{border-top-color:#ff8a70}
.alert-warning
.alert-link{color:#ff643f}
.alert-danger{color:#fd5d93;background-color:#fd77a4;border-color:#fd77a4}
.alert-danger hr{border-top-color:#fd5e93}.alert-danger .alert-link{color:#fc2b71}
.alert-light{color:#adb5bd;background-color:#bac1c8;border-color:#bac1c8}
.alert-light hr{border-top-color:#acb4bd}.alert-light .alert-link{color:#919ca6}
.alert-dark{color:#212529;background-color:#45484b;border-color:#45484b}
.alert-dark hr{border-top-color:#393b3e}
.alert-dark
.alert-link{color:#0a0c0d}
.alert-default{color:#344675;background-color:#54648b;border-color:#54648b}
.alert-default hr{border-top-color:#4a597b}
.alert-default .alert-link{color:#243152}
.alert-white{color:#fff;background-color:#fff;border-color:#fff}.alert-white hr{border-top-color:#f2f2f2}
.alert-white .alert-link{color:#e6e6e6}
.alert-neutral{color:#fff;background-color:#fff;border-color:#fff}.alert-neutral hr{border-top-color:#f2f2f2}
.alert-neutral .alert-link{color:#e6e6e6}
.alert-darker{color:#000;background-color:#292929;border-color:#292929}
.alert-darker hr{border-top-color:#1c1c1c}
.alert-darker
.alert-link{color:#000}

.input_message{
  position: fixed;
  bottom: 2%;
  width: 98%;
  background-color: #fed2e1;
  margin:0.2rem;
  padding:1.5rem 0.2rem;
  border-radius:.2857rem;
  text-align: center;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  font-size: x-large;

}
.input_name{
  width:10%;
  padding:0.7rem 1rem;
  font-size: x-large;
}
.input_content{
  width:62%;
  padding:0.7rem 0.6rem;
  font-size: x-large;
}

#app {
 font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#ofBar {
  background: #fff;
  z-index: 999999999;
  font-size: 16px;
  color: #333;
  padding: 16px 40px;
  font-weight: 400;
  display: flex;
  justify-content: space-between;
  align-items: center;
  position: fixed;
  top: 40px;
  width: 80%;
  border-radius: 8px;
  left: 0;
  right: 0;
  margin-left: auto;
  margin-right: auto;
  box-shadow: 0 13px 27px -5px rgba(50,50,93,0.25), 0 8px 16px -8px rgba(0,0,0,0.3), 0 -6px 16px -6px rgba(0,0,0,0.025);
}

#ofBar-logo img {
  height: 50px;
}

#ofBar-content {
  display: inline;
  padding: 0 15px;
}

#ofBar-right {
  display: flex;
  align-items: center;
}

#ofBar b {
  font-size: 15px !important;
}
#count-down {
  display: initial;
  padding-left: 10px;
  font-weight: bold;
  font-size: 20px;
}
#close-bar {
  font-size: 17px;
  opacity: 0.5;
  cursor: pointer;
}
#close-bar:hover{
  opacity: 1;
}
#btn-bar {
  background-image: linear-gradient(310deg, #141727 0%, #3A416F 100%);
  color: #fff;
  border-radius: 4px;
  padding: 10px 20px;
  font-weight: bold;
  text-transform: uppercase;
  text-align: center;
  font-size: 12px;
  opacity: .95;
  margin-right: 20px;
  box-shadow: 0 5px 10px -3px rgba(0,0,0,.23), 0 6px 10px -5px rgba(0,0,0,.25);
}
#btn-bar, #btn-bar:hover, #btn-bar:focus, #btn-bar:active {
  text-decoration: none !important;
  color: #fff !important;
}
#btn-bar:hover{
  opacity: 1;
}

#btn-bar span, #ofBar-content span {
  color: red;
  font-weight: 700;
}

#oldPriceBar {
  text-decoration: line-through;
  font-size: 16px;
  color: #fff;
  font-weight: 400;
  top: 2px;
  position: relative;
}
#newPrice{
  color: #fff;
  font-size: 19px;
  font-weight: 700;
  top: 2px;
  position: relative;
  margin-left: 7px;
}

#fromText {
  font-size: 15px;
  color: #fff;
  font-weight: 400;
  margin-right: 3px;
  top: 0px;
  position: relative;
}

@media(max-width: 991px){

}
@media (max-width: 768px) {
  #count-down {
    display: block;
    margin-top: 15px;
  }

  #ofBar {
    flex-direction: column;
    align-items: normal;
  }

  #ofBar-content {
    margin: 15px 0;
    text-align: center;
    font-size: 18px;
  }

  #ofBar-right {
    justify-content: flex-end;
  }
}
</style>
<!--
<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <HelloWorld msg="Welcome to Your Vue.js App"/>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
-->