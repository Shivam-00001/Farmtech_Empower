
  // Import the functions you need from the SDKs you need
  
  import { initializeApp } from "https://www.gstatic.com/firebasejs/10.13.1/firebase-app.js";
  import { getAuth,GoogleAuthProvider,signInWithPopup} from "https://www.gstatic.com/firebasejs/10.13.1/firebase-auth.js";
 // TODO: Add SDKs for Firebase products that you want to use
  // https://firebase.google.com/docs/web/setup#available-libraries

  // Your web app's Firebase configuration
  // For Firebase JS SDK v7.20.0 and later, measurementId is optional
  const firebaseConfig = {
    apiKey: "AIzaSyBNfr9FokjcHchVmTQ9FJrwhaHGVuSDXRU",
    authDomain: "farmtechempower.firebaseapp.com",
    projectId: "farmtechempower",
    storageBucket: "farmtechempower.appspot.com",
    messagingSenderId: "34681503235",
    appId: "1:34681503235:web:901a0b5f875951417e5836",
    measurementId: "G-774274S893"
  };

  // Initialize Firebase
  const app = initializeApp(firebaseConfig);
  const auth = getAuth(app);
  auth.langugeCode= 'it'
  const provider = new GoogleAuthProvider();

  
  const googleLogin = document.getElementById("btn btn-google");
  googleLogin.addEventListener("click",function(){
	alert(5);
  });