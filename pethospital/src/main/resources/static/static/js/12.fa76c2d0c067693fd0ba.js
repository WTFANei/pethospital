webpackJsonp([12],{XKZq:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s={data:function(){return{User:{},postData:{token:"-wB7gbMbeR_0yOZ_Pige0M_YtUHPTBsggN6fj6lB:PsuGZL4KqMZN6ztbth_o6eFW5KU=:eyJzY29wZSI6ImNyaXNtIiwiZGVhZGxpbmUiOjE1MjEzMDEwMzR9"},imageUrl:"",active:0,btntext:"下一步",ruleForm:{flag:!1},rules:{name:[{required:!0,message:"请输入漫画名称",trigger:"blur"},{min:1,max:20,message:"长度在 1 到 20 个字符",trigger:"blur"}],author:[{required:!0,message:"请输入作者名称",trigger:"blur"},{min:1,max:15,message:"长度在 1 到 15 个字符",trigger:"blur"}],tag:[{required:!0,message:"请选择漫画题材",trigger:"change"}],desc:[{required:!0,message:"请填写漫画简介",trigger:"blur"}],cover:[{required:!0,validator:function(t,e,a){""===e?a(new Error("请输入内容！")):a()},trigger:"blur"}]}}},created:function(){this.User=JSON.parse(sessionStorage.getItem("u")),null===this.User?this.$router.push("/login"):this.ruleForm.uid=this.User.uid,null!=this.$route.query.cid&&this.getComic(this.$route.query.cid)},methods:{getComic:function(t){var e=this;this.$ajax.post("/api/getComicsById?cid="+t).then(function(t){0===t.data.code&&(e.ruleForm=t.data.data,e.imageUrl=e.ruleForm.cover)}).catch(function(t){console.log(t)})},handleAvatarSuccess:function(t,e){this.imageUrl="http://p24hjnsdi.bkt.clouddn.com/"+t.key},handleError:function(t){console.log(t)},next:function(){++this.active>=3?this.btntext="提交":this.btntext="下一步",this.active>4&&(this.active=4)},prev:function(){this.active>=3?this.active=2:this.active<=0?this.active=0:this.active--,this.btntext="下一步"},submitForm:function(t){var e=this;if(1===this.active&&(this.ruleForm.cover=this.imageUrl),this.$refs[t].validate(function(t){if(!t)return!1;e.next()}),4===this.active){console.log(this.ruleForm);var a=this;this.$ajax.post("/api/createComics",a.ruleForm).then(function(t){console.log(t.data),a.$router.push("/comic")}).catch(function(t){console.log(t)}),a.active=5}},resetForm:function(t){this.$refs[t].resetFields()}}},i={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"content"},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:5===t.active,expression:"active === 5"}],staticClass:"contianer"},[a("el-steps",{attrs:{simple:"",active:t.active,"finish-status":"success"}},[a("el-step",{attrs:{title:"新建漫画",icon:"el-icon-edit"}}),t._v(" "),a("el-step",{attrs:{title:"漫画封面",icon:"el-icon-upload"}}),t._v(" "),a("el-step",{attrs:{title:"完成",icon:"el-icon-success"}})],1),t._v(" "),a("div",{staticClass:"form"},[a("el-form",{ref:"ruleForm",attrs:{model:t.ruleForm,rules:t.rules,"label-width":"100px"}},[a("div",{directives:[{name:"show",rawName:"v-show",value:0===t.active,expression:"active === 0"}]},[a("el-form-item",{attrs:{label:"漫画名称",prop:"name"}},[a("el-input",{model:{value:t.ruleForm.name,callback:function(e){t.$set(t.ruleForm,"name",e)},expression:"ruleForm.name"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"作者名称",prop:"author"}},[a("el-input",{model:{value:t.ruleForm.author,callback:function(e){t.$set(t.ruleForm,"author",e)},expression:"ruleForm.author"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"题材分类",prop:"tag"}},[a("el-radio-group",{model:{value:t.ruleForm.tag,callback:function(e){t.$set(t.ruleForm,"tag",e)},expression:"ruleForm.tag"}},[a("el-radio",{attrs:{label:"搞笑"}}),t._v(" "),a("el-radio",{attrs:{label:"奇幻"}}),t._v(" "),a("el-radio",{attrs:{label:"热血"}}),t._v(" "),a("el-radio",{attrs:{label:"格斗"}}),t._v(" "),a("el-radio",{attrs:{label:"恐怖"}}),t._v(" "),a("el-radio",{attrs:{label:"悬疑"}}),t._v(" "),a("el-radio",{attrs:{label:"科幻"}}),t._v(" "),a("el-radio",{attrs:{label:"魔幻"}}),t._v(" "),a("el-radio",{attrs:{label:"励志"}}),t._v(" "),a("el-radio",{attrs:{label:"校园"}})],1)],1),t._v(" "),a("el-form-item",{attrs:{label:"漫画简介",prop:"desc"}},[a("el-input",{attrs:{type:"textarea",rows:5},model:{value:t.ruleForm.desc,callback:function(e){t.$set(t.ruleForm,"desc",e)},expression:"ruleForm.desc"}})],1)],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:1===t.active,expression:"active === 1"}]},[a("el-form-item",{attrs:{prop:"cover"}},[a("el-upload",{staticClass:"upimg",attrs:{drag:"",action:"https://upload-z2.qiniup.com",data:t.postData,"on-success":t.handleAvatarSuccess,limit:1}},[t.imageUrl?a("img",{staticClass:"avatar",staticStyle:{width:"240px",height:"320px"},attrs:{src:t.imageUrl}}):t._e(),t._v(" "),a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),a("em",[t._v("点击上传")])]),t._v(" "),a("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("只能上传320*240尺寸的jpg/png文件，且不超过500kb")])])],1)],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:2===t.active,expression:"active === 2"}],staticClass:"protocol"},[a("p",{staticClass:"t"},[t._v("《漫本漫画内容上传协议》")]),t._v(" "),a("p",[t._v("请务必认真阅读和理解本《漫本漫画内容上传协议》（以下简称“协议”）中规定的所有权利和限制。您（“用户”）一旦注册、登录、使用等行为将视为对本《协议》的接受，即表示您同意接受本《协议》各项条款的约束。如果您不同意本《协议》中的条款，您可以放弃注册、登录或使用本协议所涉及的相关服务。")]),t._v(" "),a("p",[t._v("本《协议》是用户与上海瑛麒动漫科技有限公司（下称“漫本漫画”）之间的法律协议。")]),t._v(" "),a("h1",[t._v("一、定义")]),t._v(" "),a("p",[t._v("1、“漫本原创漫画发行平台”是指上海瑛麒动漫科技有限公司旗下所属的互联网网站平台（http://www.manben.com）、智能手机及平板电脑的包括但不限于漫画等应用程序及上海瑛麒动漫科技有限公司与第三方网站合作搭建的漫本漫画合作推广专区等网络产品及应用，简称“漫本漫画”。")]),t._v(" "),a("p",[t._v("2、“用户”是指愿意接受本协议，注册成为漫本漫画用户并使用漫本漫画提供的网络服务的个人、单位或任何组织。")]),t._v(" "),a("p",[t._v("3、“转载”是指用户从互联网上收集的、非为用户创作的内容作品发布到漫本漫画的行为。")]),t._v(" "),a("p",[t._v("4、“无授权转载”是指未经著作权人授权，擅自将他人作品发布到漫本漫画的行为。")]),t._v(" "),a("p",[t._v("5、“漫本漫画合作推广专区”系指上海瑛麒动漫科技有限公司以宣传推广用户上传之内容为目的，与第三方网站合作设立的推广专区，通过包括但不限于网页调用等方式调用漫本漫画网站中的内容向第三方网站用户提供阅读和浏览服务，漫本漫画合作推广专区属于漫本漫画网站的一部分。")]),t._v(" "),a("h1",[t._v("二、内容上传")]),t._v(" "),a("p",[t._v("1、漫本漫画依法禁止出版、传播或者含有下列内容之一的作品：")]),t._v(" "),a("p",{staticClass:"item"},[t._v("a 、反对宪法所确定的基本原则的；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("b 、危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("c 、损害国家荣誉和利益的；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("d 、煽动民族仇恨、民族歧视，破坏民族团结的；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("e 、破坏国家宗教政策，宣扬邪教和封建迷信的；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("f 、散布谣言，扰乱社会秩序，破坏社会稳定的；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("g 、散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("h 、侮辱或者诽谤他人，侵害他人合法权益的；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("i 、含有法律、行政法规禁止的其他内容的。")]),t._v(" "),a("p",[t._v("2、内容上传要求：")]),t._v(" "),a("p",[t._v("在漫本漫画中，所上传的内容应遵守以下规定;")]),t._v(" "),a("p",{staticClass:"item"},[t._v("a 、用户于漫本漫画所上传的一切内容，均应为漫画作品或与漫画作品相关的图片作品；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("b 、上传内容中凡选择标注为“原创”的，用户应保证该内容完全为用户本人独立创作，拥有完整、合法的权利在漫本漫画上传、发布、传播，不得侵犯其他任何第三方的著作权、或其他任何合法权益；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("c 、上传内容中凡标注为“转载”的，用户应当保证已经获得著作权人的授权拥有在互联网上发布该等内容的相关权利，或原作者明确声明允许自由转载（此种情况应附相关声明原文）；同时，用户应当标注原作者的署名，如原作者的授权（或允许转载的相关声明原文）中要求的，应当同时标注作品的出处；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("e 、用户上传无权发布、传播或侵犯其他任何第三方的著作权或其他任何合法权益的作品的，将被视为漫本禁止的无授权转载行为。")]),t._v(" "),a("p",{staticClass:"item"},[t._v("f 、未经漫本漫画书面同意，用户不得在漫本漫画发布任何广告消息。")]),t._v(" "),a("p",{staticClass:"item"},[t._v("g、未经漫本事先书面同意，用户不得擅自使用、复制或授权他人使用漫本漫画的商标、标志及其他任何显著性标识。")]),t._v(" "),a("h1",[t._v("三、对于无授权转载的处理")]),t._v(" "),a("p",[t._v("1、漫本漫画作为信息存储空间、及网络服务提供者，对用户无授权转载行为的发生不具备充分的监控能力。如权利人认为用户上传的内容侵犯其著作权，并向漫本漫画提交书面通知，要求漫本漫画删除该上传内容的，漫本漫画有权删除该上传内容并将该通知书及权利人附交的证据转发给用户。如用户注册时填写的联系方式不明或因其他原因无法转交的，漫本漫画有权将通知书的内容在漫本漫画上公告，视为送达。")]),t._v(" "),a("p",[t._v("2、用户接到漫本漫画转送的通知书后，认为上传的内容未侵犯他人权利的，可以向漫本漫画提交书面说明，要求恢复被删除的上传内容。反通知应当包含下列内容：")]),t._v(" "),a("p",{staticClass:"item"},[t._v("a 、用户的真实姓名、联系方式和地址；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("b 、要求恢复的上传内容的名称；")]),t._v(" "),a("p",{staticClass:"item"},[t._v("c 、不构成侵权的证明材料。")]),t._v(" "),a("p",[t._v("3、漫本漫画收到用户的书面说明后，会立即删除漫本漫画上的公告（如已发布）。漫本漫画有权自主决定是否恢复被删除的上传内容。")]),t._v(" "),a("p",[t._v("4、用户违反本协议的，漫本漫画有权要求用户对漫本漫画因此所遭受到的损失进行赔偿（包括但不限于因此而产生的罚款、赔偿、补偿、违约金、律师费、公证费和诉讼费等费用）。 ")]),t._v(" "),a("h1",[t._v("四、免责声明")]),t._v(" "),a("p",[t._v("1、凡用户上传之内容，版权责任由用户自负，漫本漫画仅提供存放空间并供用户展示之用。漫本漫画有权对上传内容进行筛选，审核，排版，推荐。漫本漫画有权不事先通知用户即撤消或删除上传内容，并无需向用户承担任何责任。")]),t._v(" "),a("p",[t._v("2、漫本漫画不就因用户使用服务引起的或与服务有关的任何意外的、非直接的、特殊的、或间接的损害或请求（包括但不限于因人身伤害、因隐私泄漏、因未能履行包括诚信或合理谨慎在内的任何责任、因过失和因任何其他金钱上的损失或其他损失而造成的损害赔偿）承担任何责任。")]),t._v(" "),a("p",[t._v("3、漫本漫画有权利为宣传漫本漫画之目的使用用户上传的内容，并无需向用户支付任何费用或承担任何责任，但不得以收费方式向公众提供该内容的在线阅读和浏览服务，亦不得在未经用户书面同意的情况下以任何形式授权第三人使用。")]),t._v(" "),a("p",[t._v("4、漫本漫画在宣传推广用户上传的内容（包括但不限于在广告、推荐位、漫本漫画合作推广专区中推广）时，有权同时标注漫本漫画的标识（包括但不限于相关的文字表述、漫本漫画的名称、LOGO等）。")]),t._v(" "),a("h1",[t._v("五、漫本漫画的承诺")]),t._v(" "),a("p",[t._v("漫本漫画承诺将善意地向第三方宣传和推广用户上传的内容，在未经通知并与用户达成一致前，不会以收费方式向公众提供该内容的线下和/或在线的阅读和浏览服务，或通过向第三方合作伙伴收费的形式向其提供用户上传的内容。")]),t._v(" "),a("h1",[t._v("六、争议解决")]),t._v(" "),a("p",[t._v("1、本协议的订立、执行和解释及争议的解决均应适用中华人民共和国法律。")]),t._v(" "),a("p",[t._v("2、如用户与漫本漫画就本协议的内容或其履行发生任何争议，协商不成时，任何一方均可向上海市仲裁委员会申请仲裁，仲裁地点为上海，仲裁裁决是终局的，对双方均有约束力。")]),t._v(" "),a("h1",[t._v("七、其他")]),t._v(" "),a("p",[t._v("1、漫本漫画未能及时行使本协议项下的权利不应被视为放弃该权利，也不影响在将来行使该权利。")]),t._v(" "),a("p",[t._v("2、漫本漫画在法律允许的最大范围内对本协议拥有解释权与修改权。")]),t._v(" "),a("p",[t._v("3、如用户与上海瑛麒动漫科技有限公司签订了其他书面合同的，本协议作为该书面合同的一部分，与该书面合同具同等效力；该书面合同与本协议规定不一致的，适用书面合同的规定。")]),t._v(" "),a("div",{staticClass:"toolBar"},[a("a",{attrs:{href:"javascript:window.close();"}})])]),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:3===t.active,expression:"active === 3"}]},[a("el-form-item",{attrs:{label:"存稿／发布",prop:"flag"}},[a("el-switch",{model:{value:t.ruleForm.flag,callback:function(e){t.$set(t.ruleForm,"flag",e)},expression:"ruleForm.flag"}})],1)],1),t._v(" "),a("el-form-item",[a("el-button",{staticStyle:{margin:"40px 0 20px -70px"},on:{click:function(e){t.prev()}}},[t._v("上一步")]),t._v(" "),a("el-button",{on:{click:function(e){t.submitForm("ruleForm")}}},[t._v(t._s(t.btntext))])],1)],1)],1)],1)])},staticRenderFns:[]};var r=a("VU/8")(s,i,!1,function(t){a("yYGT")},null,null);e.default=r.exports},yYGT:function(t,e){}});
//# sourceMappingURL=12.fa76c2d0c067693fd0ba.js.map