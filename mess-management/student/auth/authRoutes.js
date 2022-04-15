const express = require('express');
const router = express.Router();
const authController = require('./authController.js');

router.get('/login', authController.getLogin)

router.post('/login', authController.postLogin)

router.get('/logout',authController.getLogout)

router.get("/studentHome",authController.getHome);

router.post("/loginmanager",authController.getManagerLogin);

router.get("/managerhome",authController.getManagerHome);

router.get("/knoworders",authController.getKnowOrders);

router.get("/managerdues",authController.getManagerDues);

router.get("/messmenu",authController.getMessMenu);


// cookies 

// router.get('/set-cookies' ,(req,res)=> {
// //     res.setHeader('Set-Cookie','newUser=true')
// //     res.send('you got cookies')

// // new method cookie-parser
//  res.cookie('newUser',false)
//  res.cookie('isEmployee',false,{maxAge : 1000*60*60*24,/*secure : true,httpOnly : true*/}) // miliseconds, cookie only be sent when we have http secure connection , cannnot be accesed by document.xookie in fronte js
//  res.send('you got cookies')
 
//  })
// router.get('/read-cookies',(rea,res)=>{
//     const cookies = req.cookies;
// })

module.exports = router