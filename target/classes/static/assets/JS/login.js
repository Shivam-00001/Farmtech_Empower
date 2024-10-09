  // Initialize Firebase
  const app = initializeApp(firebaseConfig);
  const auth = getAuth(app);
  auth.langugeCode= 'it'
  const provider = new GoogleAuthProvider();

  
  const googleLogin = document.getElementById("btn btn-google");
  googleLogin.addEventListener("click",function(){
	alert(5);
  });