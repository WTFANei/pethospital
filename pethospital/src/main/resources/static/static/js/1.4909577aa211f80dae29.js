webpackJsonp([1],{"6Z0W":function(e,t){},LYiy:function(e,t){},Z7wP:function(e,t){},gf1O:function(e,t){},iYPu:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=r("mvHQ"),s=r.n(a),l={data:function(){var e=function(e,t,r){""===t?r(new Error("请输入内容！")):r()};return{logining:!1,loadShow:!0,regForm:{email:"",birth:"",uid:"",name:"",sex:""},regRules:{uid:[{required:!0,validator:e,trigger:"blur"}],name:[{required:!0,validator:e,trigger:"blur"}],sex:[{required:!0,message:"请选择性别！",trigger:"change"}]}}},props:["user"],created:function(){this.regForm=this.user},methods:{regSubmit:function(){var e=this;console.log(this.regForm);var t=this;this.$refs.regForm.validate(function(r){if(!r)return!1;e.$ajax.post("/api/c/updateUserInfo",t.regForm).then(function(e){0===e.data.code&&sessionStorage.setItem("u",s()(t.regForm))}).catch(function(e){console.log(e)})})},resetForm:function(e){this.$refs[e].resetFields()}}},i={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"panel"},[r("el-form",{ref:"regForm",attrs:{model:e.regForm,"status-icon":"",rules:e.regRules}},[r("el-form-item",{attrs:{prop:"name",label:"昵称：","label-width":"80px"}},[r("el-input",{attrs:{type:"text",placeholder:"昵称",disabled:!0,maxlength:20,size:"large"},model:{value:e.regForm.name,callback:function(t){e.$set(e.regForm,"name",t)},expression:"regForm.name"}})],1),e._v(" "),e.regForm.sex?r("el-form-item",{attrs:{prop:"sex",label:"性别：","label-width":"80px"}},[r("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"性别"},model:{value:e.regForm.sex,callback:function(t){e.$set(e.regForm,"sex",t)},expression:"regForm.sex"}},[r("el-option",{attrs:{label:"男",value:"男"}}),e._v(" "),r("el-option",{attrs:{label:"女",value:"女"}})],1)],1):e._e(),e._v(" "),e.regForm.birth?r("el-form-item",{attrs:{prop:"birth",label:"生日：","label-width":"80px"}},[r("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"date",format:"yyyy-MM-dd",placeholder:"出生日期"},model:{value:e.regForm.birth,callback:function(t){e.$set(e.regForm,"birth",t)},expression:"regForm.birth"}})],1):e._e(),e._v(" "),r("el-form-item",{attrs:{prop:"email",label:"邮箱：","label-width":"80px",rules:[{required:!0,message:"请输入邮箱地址",trigger:"blur"},{type:"email",message:"请输入正确的邮箱地址",trigger:"blur,change"}]}},[r("el-input",{attrs:{placeholder:"邮箱"},model:{value:e.regForm.email,callback:function(t){e.$set(e.regForm,"email",t)},expression:"regForm.email"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"类型：","label-width":"80px"}},[r("el-input",{attrs:{type:"text",placeholder:"用户类型",disabled:!0,maxlength:11,size:"large"},model:{value:e.regForm.type,callback:function(t){e.$set(e.regForm,"type",t)},expression:"regForm.type"}},[e._v("1")])],1),e._v(" "),r("el-form-item",{staticClass:"login-btn",staticStyle:{width:"100%"},attrs:{"label-width":"80px"}},[r("el-button",{staticStyle:{width:"100%"},attrs:{type:"primary",size:"large"},nativeOn:{click:function(t){return t.preventDefault(),e.regSubmit(t)}}},[e._v("提交")])],1)],1)],1)},staticRenderFns:[]};var o={data:function(){var e=this;return{RePwd:{userId:"",pass:"",newPwd:"",userPwd:""},rules2:{pass:[{validator:function(t,r,a){""===r?a(new Error("请输入新密码")):(""!==e.RePwd.newPwd&&e.$refs.RePwd.validateField("newPwd"),a())},trigger:"blur"},{min:6,max:16,message:"密码 6-20 位之间！",trigger:"blur"}],newPwd:[{validator:function(t,r,a){""===r?a(new Error("请再次输入密码")):r!==e.RePwd.pass?a(new Error("两次输入密码不一致!")):a()},trigger:"blur"},{min:6,max:16,message:"密码 6-20 位之间！",trigger:"blur"}],userPwd:[{required:!0,message:"请输入密码！",trigger:"blur"},{min:6,max:16,message:"密码 6-20 位之间！",trigger:"blur"}]}}},methods:{submitForm:function(e){var t=this,r=this,a=JSON.parse(sessionStorage.getItem("u"));r.RePwd.userId=a.uid,console.log(a),this.$refs[e].validate(function(e){if(!e)return!1;t.$ajax.post("/api/c/modifyPwd",r.RePwd).then(function(e){0===e.data.code?(r.$message({message:e.data.data,type:"success"}),r.logout()):r.$message({message:e.data.msg,type:"error"})}).catch(function(e){console.log(e)})})},logout:function(){sessionStorage.removeItem("u"),this.$router.push("/login")},resetForm:function(e){this.$refs[e].resetFields()}}},n={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"panel"},[r("el-form",{ref:"RePwd",staticClass:"demo-ruleForm",staticStyle:{},attrs:{model:e.RePwd,rules:e.rules2}},[r("el-form-item",{attrs:{prop:"userPwd"}},[r("el-input",{attrs:{type:"password",size:"large",placeholder:"旧密码"},model:{value:e.RePwd.userPwd,callback:function(t){e.$set(e.RePwd,"userPwd",t)},expression:"RePwd.userPwd"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"pass"}},[r("el-input",{attrs:{type:"password",size:"large","auto-complete":"off",placeholder:"新密码"},model:{value:e.RePwd.pass,callback:function(t){e.$set(e.RePwd,"pass",t)},expression:"RePwd.pass"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"newPwd"}},[r("el-input",{attrs:{type:"password",size:"large","auto-complete":"off",placeholder:"重复密码"},model:{value:e.RePwd.newPwd,callback:function(t){e.$set(e.RePwd,"newPwd",t)},expression:"RePwd.newPwd"}})],1),e._v(" "),r("el-form-item",[r("el-button",{staticStyle:{width:"47%"},attrs:{size:"large",type:"primary"},on:{click:function(t){e.submitForm("RePwd")}}},[e._v("提交")]),e._v(" "),r("el-button",{staticStyle:{width:"48%"},attrs:{size:"large"},on:{click:function(t){e.resetForm("RePwd")}}},[e._v("重置")])],1)],1)],1)},staticRenderFns:[]};var c={data:function(){var e=function(e,t,r){""===t?r(new Error("请输入内容！")):r()};return{postData:{token:"-wB7gbMbeR_0yOZ_Pige0M_YtUHPTBsggN6fj6lB:PsuGZL4KqMZN6ztbth_o6eFW5KU=:eyJzY29wZSI6ImNyaXNtIiwiZGVhZGxpbmUiOjE1MjEzMDEwMzR9"},imageUrl:"",logining:!1,loadShow:!0,regForm:{realName:"",cardNum:"",cardPic:""},regRules:{realName:[{required:!0,validator:e,trigger:"blur"}],cardNum:[{required:!0,validator:e,trigger:"blur"},{min:18,max:18,message:"请输入正确的身份号码！",trigger:"blur"}],cardPic:[{required:!0,validator:e,trigger:"blur"}],sex:[{required:!0,message:"请选择性别！",trigger:"change"}],birth:[{type:"date",required:!0,message:"请选择日期",trigger:"change"}]}}},created:function(){this.regForm.name=JSON.parse(sessionStorage.getItem("u")).name},methods:{handleAvatarSuccess:function(e,t){this.imageUrl="http://p24hjnsdi.bkt.clouddn.com/"+e.key,console.log(e)},handleError:function(e){console.log(e)},beforeAvatarUpload:function(e){var t="image/jpeg"===e.type,r="image/png"===e.type,a=e.size/1024/1024<2;return t||r||this.$message.error("上传头像图片只能是 JPG/PNG 格式!"),a||this.$message.error("上传头像图片大小不能超过 2MB!"),t&&r&&a},regSubmit:function(){var e=this,t=this;t.regForm.cardPic=t.imageUrl,this.$refs.regForm.validate(function(r){if(!r)return!1;e.$ajax.post("/api/c/becomeAuthor",t.regForm).then(function(e){}).catch(function(e){console.log(e)})})},resetForm:function(e){this.$refs[e].resetFields()}}},u={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"panel"},[r("el-form",{ref:"regForm",attrs:{model:e.regForm,"status-icon":"",rules:e.regRules}},[r("el-form-item",{attrs:{label:"姓名：","label-width":"95px",prop:"realName"}},[r("el-input",{attrs:{type:"text",placeholder:"真实姓名",maxlength:20,size:"large"},model:{value:e.regForm.realName,callback:function(t){e.$set(e.regForm,"realName",t)},expression:"regForm.realName"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"性别：","label-width":"95px",prop:"sex"}},[r("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"性别"},model:{value:e.regForm.sex,callback:function(t){e.$set(e.regForm,"sex",t)},expression:"regForm.sex"}},[r("el-option",{attrs:{label:"男",value:"男"}}),e._v(" "),r("el-option",{attrs:{label:"女",value:"女"}})],1)],1),e._v(" "),r("el-form-item",{attrs:{label:"生日：","label-width":"95px",prop:"birth"}},[r("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"date",format:"yyyy-MM-dd",placeholder:"出生日期"},model:{value:e.regForm.birth,callback:function(t){e.$set(e.regForm,"birth",t)},expression:"regForm.birth"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"身份证号：","label-width":"95px",prop:"cardNum"}},[r("el-input",{attrs:{type:"number",placeholder:"身份证号",maxlength:18,size:"large"},model:{value:e.regForm.cardNum,callback:function(t){e.$set(e.regForm,"cardNum",t)},expression:"regForm.cardNum"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"cardPic"}},[r("el-upload",{staticClass:"upload-demo",attrs:{drag:"",action:"https://upload-z2.qiniup.com",data:e.postData,"on-success":e.handleAvatarSuccess,multiple:""}},[e.imageUrl?r("img",{staticClass:"avatar",staticStyle:{width:"360px",height:"180px"},attrs:{src:e.imageUrl}}):e._e(),e._v(" "),r("i",{staticClass:"el-icon-upload"}),e._v(" "),r("div",{staticClass:"el-upload__text"},[e._v("将文件拖到此处，或"),r("em",[e._v("点击上传")])]),e._v(" "),r("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("只能上传jpg/png文件，且不超过500kb")])])],1),e._v(" "),r("el-form-item",{staticClass:"login-btn",staticStyle:{width:"100%"}},[r("el-button",{staticStyle:{width:"100%"},attrs:{type:"primary",size:"large"},nativeOn:{click:function(t){return t.preventDefault(),e.regSubmit(t)}}},[e._v("提交")])],1)],1)],1)},staticRenderFns:[]};var d={data:function(){return{User:{}}},methods:{},components:{Info:r("VU/8")(l,i,!1,function(e){r("LYiy")},"data-v-6fe6dfe0",null).exports,Repwd:r("VU/8")(o,n,!1,function(e){r("gf1O")},"data-v-f95a1f98",null).exports,Permit:r("VU/8")(c,u,!1,function(e){r("Z7wP")},"data-v-23d2dc60",null).exports},created:function(){this.User=JSON.parse(sessionStorage.getItem("u"))}},m={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"content"},[t("div",{staticClass:"banaer"},[t("div",{staticClass:"container"},[t("div",{staticClass:"userCenterBar"},[t("el-tabs",{attrs:{"tab-position":"left"}},[t("el-tab-pane",{attrs:{label:"个人中心"}},[t("Info",{attrs:{user:this.User}})],1),this._v(" "),this.User.type<2?t("el-tab-pane",{attrs:{label:"成为作者"}},[t("Permit")],1):this._e(),this._v(" "),t("el-tab-pane",{attrs:{label:"账户安全"}},[t("Repwd")],1)],1)],1)])])])},staticRenderFns:[]};var g=r("VU/8")(d,m,!1,function(e){r("6Z0W")},null,null);t.default=g.exports},mvHQ:function(e,t,r){e.exports={default:r("qkKv"),__esModule:!0}},qkKv:function(e,t,r){var a=r("FeBl"),s=a.JSON||(a.JSON={stringify:JSON.stringify});e.exports=function(e){return s.stringify.apply(s,arguments)}}});
//# sourceMappingURL=1.4909577aa211f80dae29.js.map