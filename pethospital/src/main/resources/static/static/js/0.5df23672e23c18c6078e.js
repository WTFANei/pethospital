webpackJsonp([0],{"//Fk":function(t,e,n){t.exports={default:n("U5ju"),__esModule:!0}},"2KxR":function(t,e){t.exports=function(t,e,n,i){if(!(t instanceof e)||void 0!==i&&i in t)throw TypeError(n+": incorrect invocation!");return t}},"3fs2":function(t,e,n){var i=n("RY/4"),o=n("dSzd")("iterator"),r=n("/bQp");t.exports=n("FeBl").getIteratorMethod=function(t){if(void 0!=t)return t[o]||t["@@iterator"]||r[i(t)]}},"82Mu":function(t,e,n){var i=n("7KvD"),o=n("L42u").set,r=i.MutationObserver||i.WebKitMutationObserver,s=i.process,a=i.Promise,c="process"==n("R9M2")(s);t.exports=function(){var t,e,n,u=function(){var i,o;for(c&&(i=s.domain)&&i.exit();t;){o=t.fn,t=t.next;try{o()}catch(i){throw t?n():e=void 0,i}}e=void 0,i&&i.enter()};if(c)n=function(){s.nextTick(u)};else if(!r||i.navigator&&i.navigator.standalone)if(a&&a.resolve){var l=a.resolve();n=function(){l.then(u)}}else n=function(){o.call(i,u)};else{var m=!0,d=document.createTextNode("");new r(u).observe(d,{characterData:!0}),n=function(){d.data=m=!m}}return function(i){var o={fn:i,next:void 0};e&&(e.next=o),t||(t=o,n()),e=o}}},CXw9:function(t,e,n){"use strict";var i,o,r,s,a=n("O4g8"),c=n("7KvD"),u=n("+ZMJ"),l=n("RY/4"),m=n("kM2E"),d=n("EqjI"),h=n("lOnJ"),v=n("2KxR"),p=n("NWt+"),f=n("t8x9"),g=n("L42u").set,A=n("82Mu")(),C=n("qARP"),y=n("dNDb"),w=n("fJUb"),x=c.TypeError,_=c.process,b=c.Promise,N="process"==l(_),S=function(){},I=o=C.f,M=!!function(){try{var t=b.resolve(1),e=(t.constructor={})[n("dSzd")("species")]=function(t){t(S,S)};return(N||"function"==typeof PromiseRejectionEvent)&&t.then(S)instanceof e}catch(t){}}(),R=function(t){var e;return!(!d(t)||"function"!=typeof(e=t.then))&&e},j=function(t,e){if(!t._n){t._n=!0;var n=t._c;A(function(){for(var i=t._v,o=1==t._s,r=0,s=function(e){var n,r,s=o?e.ok:e.fail,a=e.resolve,c=e.reject,u=e.domain;try{s?(o||(2==t._h&&P(t),t._h=1),!0===s?n=i:(u&&u.enter(),n=s(i),u&&u.exit()),n===e.promise?c(x("Promise-chain cycle")):(r=R(n))?r.call(n,a,c):a(n)):c(i)}catch(t){c(t)}};n.length>r;)s(n[r++]);t._c=[],t._n=!1,e&&!t._h&&k(t)})}},k=function(t){g.call(c,function(){var e,n,i,o=t._v,r=F(t);if(r&&(e=y(function(){N?_.emit("unhandledRejection",o,t):(n=c.onunhandledrejection)?n({promise:t,reason:o}):(i=c.console)&&i.error&&i.error("Unhandled promise rejection",o)}),t._h=N||F(t)?2:1),t._a=void 0,r&&e.e)throw e.v})},F=function(t){return 1!==t._h&&0===(t._a||t._c).length},P=function(t){g.call(c,function(){var e;N?_.emit("rejectionHandled",t):(e=c.onrejectionhandled)&&e({promise:t,reason:t._v})})},D=function(t){var e=this;e._d||(e._d=!0,(e=e._w||e)._v=t,e._s=2,e._a||(e._a=e._c.slice()),j(e,!0))},O=function(t){var e,n=this;if(!n._d){n._d=!0,n=n._w||n;try{if(n===t)throw x("Promise can't be resolved itself");(e=R(t))?A(function(){var i={_w:n,_d:!1};try{e.call(t,u(O,i,1),u(D,i,1))}catch(t){D.call(i,t)}}):(n._v=t,n._s=1,j(n,!1))}catch(t){D.call({_w:n,_d:!1},t)}}};M||(b=function(t){v(this,b,"Promise","_h"),h(t),i.call(this);try{t(u(O,this,1),u(D,this,1))}catch(t){D.call(this,t)}},(i=function(t){this._c=[],this._a=void 0,this._s=0,this._d=!1,this._v=void 0,this._h=0,this._n=!1}).prototype=n("xH/j")(b.prototype,{then:function(t,e){var n=I(f(this,b));return n.ok="function"!=typeof t||t,n.fail="function"==typeof e&&e,n.domain=N?_.domain:void 0,this._c.push(n),this._a&&this._a.push(n),this._s&&j(this,!1),n.promise},catch:function(t){return this.then(void 0,t)}}),r=function(){var t=new i;this.promise=t,this.resolve=u(O,t,1),this.reject=u(D,t,1)},C.f=I=function(t){return t===b||t===s?new r(t):o(t)}),m(m.G+m.W+m.F*!M,{Promise:b}),n("e6n0")(b,"Promise"),n("bRrM")("Promise"),s=n("FeBl").Promise,m(m.S+m.F*!M,"Promise",{reject:function(t){var e=I(this);return(0,e.reject)(t),e.promise}}),m(m.S+m.F*(a||!M),"Promise",{resolve:function(t){return w(a&&this===s?b:this,t)}}),m(m.S+m.F*!(M&&n("dY0y")(function(t){b.all(t).catch(S)})),"Promise",{all:function(t){var e=this,n=I(e),i=n.resolve,o=n.reject,r=y(function(){var n=[],r=0,s=1;p(t,!1,function(t){var a=r++,c=!1;n.push(void 0),s++,e.resolve(t).then(function(t){c||(c=!0,n[a]=t,--s||i(n))},o)}),--s||i(n)});return r.e&&o(r.v),n.promise},race:function(t){var e=this,n=I(e),i=n.reject,o=y(function(){p(t,!1,function(t){e.resolve(t).then(n.resolve,i)})});return o.e&&i(o.v),n.promise}})},D3BM:function(t,e){},EqBC:function(t,e,n){"use strict";var i=n("kM2E"),o=n("FeBl"),r=n("7KvD"),s=n("t8x9"),a=n("fJUb");i(i.P+i.R,"Promise",{finally:function(t){var e=s(this,o.Promise||r.Promise),n="function"==typeof t;return this.then(n?function(n){return a(e,t()).then(function(){return n})}:t,n?function(n){return a(e,t()).then(function(){throw n})}:t)}})},HTkA:function(t,e){t.exports="data:image/gif;base64,R0lGODlhZABkAKIEAN7e3rq6uv///5mZmQAAAAAAAAAAAAAAACH/C05FVFNDQVBFMi4wAwEAAAAh/wtYTVAgRGF0YVhNUDw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDpBRjA4RUZDMDI3MjA2ODExODA4M0Y1OTQyMzVDRDM3MyIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpCMzE0Rjk3NDdDRTgxMUUzOUJCRjk0NjAxMUE1NzRBMCIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpCMzE0Rjk3MzdDRTgxMUUzOUJCRjk0NjAxMUE1NzRBMCIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChNYWNpbnRvc2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6RDVBMTZDQjczOTIwNjgxMTgwODNGNTk0MjM1Q0QzNzMiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QUYwOEVGQzAyNzIwNjgxMTgwODNGNTk0MjM1Q0QzNzMiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+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"},L42u:function(t,e,n){var i,o,r,s=n("+ZMJ"),a=n("knuC"),c=n("RPLV"),u=n("ON07"),l=n("7KvD"),m=l.process,d=l.setImmediate,h=l.clearImmediate,v=l.MessageChannel,p=l.Dispatch,f=0,g={},A=function(){var t=+this;if(g.hasOwnProperty(t)){var e=g[t];delete g[t],e()}},C=function(t){A.call(t.data)};d&&h||(d=function(t){for(var e=[],n=1;arguments.length>n;)e.push(arguments[n++]);return g[++f]=function(){a("function"==typeof t?t:Function(t),e)},i(f),f},h=function(t){delete g[t]},"process"==n("R9M2")(m)?i=function(t){m.nextTick(s(A,t,1))}:p&&p.now?i=function(t){p.now(s(A,t,1))}:v?(r=(o=new v).port2,o.port1.onmessage=C,i=s(r.postMessage,r,1)):l.addEventListener&&"function"==typeof postMessage&&!l.importScripts?(i=function(t){l.postMessage(t+"","*")},l.addEventListener("message",C,!1)):i="onreadystatechange"in u("script")?function(t){c.appendChild(u("script")).onreadystatechange=function(){c.removeChild(this),A.call(t)}}:function(t){setTimeout(s(A,t,1),0)}),t.exports={set:d,clear:h}},LAXc:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i={name:"MoPaging",props:{perPages:{type:Number,default:5},pageIndex:{type:Number,default:1},pageSize:{type:Number,default:10},total:{type:Number,default:0}},methods:{prev:function(){this.index>1&&this.go(this.index-1)},next:function(){this.index<this.pages&&this.go(this.index+1)},first:function(){1!==this.index&&this.go(1)},last:function(){this.index!==this.pages&&this.go(this.pages)},go:function(t){this.index!==t&&(this.index=t,this.$emit("change",this.index))}},computed:{pages:function(){return Math.ceil(this.size/this.limit)},pagers:function(){var t=[],e=this.perPages,n=this.pages,i=this.index,o=(e-1)/2,r={start:i-o,end:i+o};r.start<1&&(r.end=r.end+(1-r.start),r.start=1),r.end>n&&(r.start=r.start-(r.end-n),r.end=n),r.start<1&&(r.start=1),this.showPrevMore=r.start>1,this.showNextMore=r.end<n;for(var s=r.start;s<=r.end;s++)t.push(s);return t}},data:function(){return{index:this.pageIndex,limit:this.pageSize,size:this.total||1,showPrevMore:!1,showNextMore:!1}},watch:{pageIndex:function(t){this.index=t||1},pageSize:function(t){this.limit=t||10},total:function(t){this.size=t||1}}},o={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("ul",{staticClass:"mo-paging"},[n("li",{class:["paging-item","paging-item--prev",{"paging-item--disabled":1===t.index}],on:{click:t.prev}},[t._v("prev")]),t._v(" "),t.showPrevMore?n("li",{class:["paging-item","paging-item--more"]},[t._v("...")]):t._e(),t._v(" "),t._l(t.pagers,function(e){return n("li",{class:["paging-item",{"paging-item--current":t.index===e}],on:{click:function(n){t.go(e)}}},[t._v(t._s(e))])}),t._v(" "),t.showNextMore?n("li",{class:["paging-item","paging-item--more"]},[t._v("...")]):t._e(),t._v(" "),n("li",{class:["paging-item","paging-item--next",{"paging-item--disabled":t.index===t.pages}],on:{click:t.next}},[t._v("next")])],2)},staticRenderFns:[]};var r=n("VU/8")(i,o,!1,function(t){n("kvWB")},"data-v-82811a8e",null).exports,s={props:{title:{type:String,default:"正在载入..."}}},a={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"loading"},[e("img",{attrs:{width:"24",height:"24",src:n("HTkA")}}),this._v(" "),e("p",{staticClass:"desc"},[this._v(this._s(this.title))])])},staticRenderFns:[]};var c=n("VU/8")(s,a,!1,function(t){n("D3BM")},"data-v-7ca09a58",null).exports,u=n("//Fk"),l=n.n(u),m=n("mtWM"),d=n.n(m);var h={props:{comicsId:""},data:function(){return{pageSize:10,currentPage:1,count:0,focusState:!1,queryParam:{paramId:1},Comments:[],reForm:{},loadShow:!0}},created:function(){var t=this;null===JSON.parse(sessionStorage.getItem("u"))||void 0===JSON.parse(sessionStorage.getItem("u")).uid?(alert("请先登录！"),this.$router.push("/login")):(this.reForm.email=JSON.parse(sessionStorage.getItem("u")).email,this.reForm.fromName=JSON.parse(sessionStorage.getItem("u")).name,this.queryParam.paramId=this.comicsId,setTimeout(function(){t._getComments(),t.loadShow=!1},500))},methods:{_addComment:function(t){var e=this;(function(t){console.log(t);var e=t;return d.a.post("/api/bg/comment",e).then(function(t){return l.a.resolve(t.data)})})(t).then(function(t){0===t.code&&(e.$alert("评论成功！等待后台审核！"),e.reForm.content="")})},_addReply:function(t){var e=this;(function(t){console.log(t);var e=t;return d.a.post("/api/bg/reply",e).then(function(t){return l.a.resolve(t.data)})})(t).then(function(t){0===t.code&&(e.$alert("评论成功！等待后台审核!"),e.reForm.content="")})},_getComments:function(){var t,e,n=this;(t=this.queryParam,e=t,d.a.post("/api/bg/getComments",e).then(function(t){return l.a.resolve(t.data)})).then(function(t){n.Comments=t.data.content,n.count=t.data.totalElements})},focusclick:function(){this.focusState=!0},pageChange:function(t){this.currentPage=t,this.queryParam.page=t-1,this._getComments()},reply:function(t){this.focusclick(),this.reForm.commentId=t.commentId,this.reForm.toName=this.$refs.toName.value="@"+t.fromName},reply1:function(t,e){this.focusclick(),this.reForm.commentId=e,this.reForm.toName=this.$refs.toName.value="@"+t.fromName+" "},submit:function(){this.reForm.content.length>10?(this.reForm.commenterId=JSON.parse(sessionStorage.getItem("u")).uid,this.reForm.hasOwnProperty("toName")?(this.reForm.toName=this.reForm.toName.replace(/[@]/g,""),this._addReply(this.reForm)):(this.reForm.comicsId=this.comicsId,console.log(this.reForm.comicsId),this._addComment(this.reForm))):this.$alert({title:"错误",content:"评论内容不能少于10个字符！"})}},components:{Paging:r,Loding:c},directives:{focus:{update:function(t,e){e.value&&t.focus()}}}},v={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"CommentPanel"},[n("div",{staticClass:"reform"},[n("form",{ref:"regform",attrs:{model:t.reForm},on:{submit:function(e){return e.preventDefault(),t.submit(e)}}},[n("input",{directives:[{name:"focus",rawName:"v-focus",value:t.focusState,expression:"focusState"},{name:"model",rawName:"v-model",value:t.reForm.fromName,expression:"reForm.fromName"}],staticClass:"replyinput",attrs:{type:"text",disabled:"",placeholder:"Name：",required:"required",pattern:"^[\\u4E00-\\u9FA5A-Za-z]{3,8}",oninvalid:"setCustomValidity('输入3-8位中英文昵称！')",oninput:"setCustomValidity('')"},domProps:{value:t.reForm.fromName},on:{blur:function(e){t.focusState=!1},input:function(e){e.target.composing||t.$set(t.reForm,"fromName",e.target.value)}}}),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.reForm.email,expression:"reForm.email"}],staticClass:"replyinput",staticStyle:{float:"right"},attrs:{type:"email",disabled:"",placeholder:" Emial：",required:"required"},domProps:{value:t.reForm.email},on:{input:function(e){e.target.composing||t.$set(t.reForm,"email",e.target.value)}}}),t._v(" "),n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.reForm.content,expression:"reForm.content"}],staticClass:"replytextarea",attrs:{required:"",rows:"4",placeholder:"Comment："},domProps:{value:t.reForm.content},on:{input:function(e){e.target.composing||t.$set(t.reForm,"content",e.target.value)}}}),t._v(" "),n("span",[n("input",{directives:[{name:"model",rawName:"v-model",value:t.reForm.toName,expression:"reForm.toName"}],ref:"toName",staticStyle:{border:"none",height:"20px"},attrs:{type:"text",disabled:"disabled"},domProps:{value:t.reForm.toName},on:{input:function(e){e.target.composing||t.$set(t.reForm,"toName",e.target.value)}}})]),t._v(" "),n("button",{staticClass:"button is-danger",attrs:{type:"submit"}},[t._v("Submit")])])]),t._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:t.loadShow,expression:"loadShow"}]},[n("Loding")],1),t._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:t.count>10,expression:"count > 10"}],staticClass:"page"},[n("Paging",{attrs:{"page-index":t.currentPage,total:t.count,"page-size":t.pageSize},on:{change:t.pageChange}})],1),t._v(" "),t._l(t.Comments,function(e){return n("div",[n("div",{staticClass:"comparaent"},[n("div",{staticClass:"comheader"},[n("span",[n("i",{staticClass:"icon-comuser icon"}),t._v(" "+t._s(e.fromName))]),t._v(" "),n("span",{staticClass:"replybtn",on:{click:function(n){t.reply(e)}}},[n("i",{staticClass:"icon-reply"}),t._v(" 回复")]),t._v(" "),n("span",{staticStyle:{margin:"0 20px"}},[n("i",{staticClass:"icon-time icon"}),t._v(" "+t._s(t.getDateTime(e.updateTime)))])]),t._v(" "),n("div",{staticClass:"comcontent"},[t._v(t._s(e.content))]),t._v(" "),e.replys.length>0?n("div",{staticClass:"comchild"},t._l(e.replys,function(i){return n("div",[n("div",[n("span",[n("i",{staticClass:"icon-comuser icon"}),t._v(" "+t._s(i.fromName))]),t._v(" "),n("span",{staticClass:"replybtn",on:{click:function(n){t.reply1(i,e.commentId)}}},[n("i",{staticClass:"icon-reply"}),t._v(" 回复")]),t._v(" "),n("span",{staticStyle:{margin:"0 10px"}},[n("i",{staticClass:"icon-time icon"}),t._v(" "+t._s(t.getDateTime(i.updateTime)))])]),t._v(" "),n("div",{staticClass:"replycontent"},[t._v(" @"+t._s(i.toName)+": "+t._s(i.content))])])})):t._e()])])})],2)},staticRenderFns:[]};var p={data:function(){return{commentShow:!1,rate:3,comics:{},param:{},tableData:[],searchParam:{size:40},currentPage:1,totalCount:0}},components:{Comment:n("VU/8")(h,v,!1,function(t){n("Xfx4")},"data-v-5da9d4ed",null).exports},created:function(){this.searchParam.param=this.$route.query.cid,this.getComics(),this.getData(),this.addhit()},methods:{addfavorite:function(t){if(this.param.cid=t,null===JSON.parse(sessionStorage.getItem("u"))||void 0===JSON.parse(sessionStorage.getItem("u")).uid)this.$router.push("/login");else{var e=this;this.param.uid=JSON.parse(sessionStorage.getItem("u")).uid,this.$ajax.post("/api/addFavorite",e.param).then(function(t){0===t.data.code?e.$message({message:t.data.data,type:"success"}):e.$message({message:t.data.msg,type:"error"})}).catch(function(t){e.goindex()})}},handleCurrentChange:function(t){this.searchParam.page=t-1,this.currentPage=t,this.getData()},addhit:function(){this.$ajax.post("/api/hitComics?cid="+this.$route.query.cid).then(function(t){}).catch(function(t){})},getComics:function(){var t=this;this.$ajax.post("/api/getComicsById?cid="+t.$route.query.cid).then(function(e){0===e.data.code?t.comics=e.data.data:t.goindex()}).catch(function(e){t.goindex()})},getData:function(){var t=this;this.$ajax.post("/api/getSectionByState",t.searchParam).then(function(e){t.tableData=e.data.data.content,t.totalCount=e.data.data.totalElements,console.log(e.data)}).catch(function(t){console.log(t)})},goLink:function(t,e,n){this.$router.push({path:t,query:{cid:e,n:this.comics.name,pid:n}})},goindex:function(){this.$router.push("/index")}}},f={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticStyle:{height:"0px"}},[n("div",{staticClass:"bgborder",style:"background-image:url("+t.comics.cover+")"}),t._v(" "),n("div",{staticClass:"details"},[n("div",{staticClass:"cover"},[n("img",{attrs:{src:t.comics.cover,alt:""}})]),t._v(" "),n("div",{staticClass:"info"},[n("p",{staticClass:"title"},[t._v(t._s(t.comics.name)+"\n        "),n("span",{staticClass:"right"},[n("i",{staticClass:"el-icon-star-on",staticStyle:{color:"#FFEC8B"}}),t._v(" "),n("a",[t._v(t._s(t.comics.favor))])])]),t._v(" "),n("p",{staticClass:"subtitle"},[t._v("作者："+t._s(t.comics.author))]),t._v(" "),n("p",{staticClass:"tip"},[n("span",{staticClass:"block"},[t._v(" 状态："+t._s(t.comics.state?"连载中":"停更"))]),t._v(" "),n("span",{staticClass:"block"},[t._v(" 热度："+t._s(t.comics.hit))]),t._v(" "),n("span",{staticClass:"block"},[t._v("题材："+t._s(t.comics.tag))])]),t._v(" "),n("p",{staticClass:"content"},[t._v("\n        "+t._s(t.comics.desc)+"\n      ")]),t._v(" "),n("p",{staticClass:"bottom"},[n("a",{staticClass:"btn-1",on:{click:function(e){t.addfavorite(t.comics.cid)}}},[t._v("收藏")]),t._v(" "),n("a",{staticClass:"btn-2",on:{click:function(e){t.goLink("/read",t.comics.cid,1)}}},[t._v("阅读")])])])]),t._v(" "),n("div",{staticClass:"view-comment"},[n("div",{staticClass:"container"},[n("ul",{staticClass:"detailist"},t._l(t.tableData,function(e){return n("a",{on:{click:function(n){t.goLink("/read",t.comics.cid,e.chapter)}}},[n("li",[t._v("第"+t._s(e.chapter)+"章   "+t._s(e.title))])])})),t._v(" "),n("div",{staticClass:"pager"},[n("div",{directives:[{name:"show",rawName:"v-show",value:0===t.totalCount,expression:"totalCount===0"}]},[t._v("暂无数据！")]),t._v(" "),n("el-pagination",{directives:[{name:"show",rawName:"v-show",value:0!=t.totalCount,expression:"totalCount!=0"}],attrs:{layout:"prev, pager, next","current-page":t.currentPage,total:t.totalCount},on:{"current-change":t.handleCurrentChange}})],1),t._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:!t.commentShow,expression:"!commentShow"}],staticClass:"readme",on:{click:function(e){t.commentShow=!0}}},[t._v(" 查看评论 ")]),t._v(" "),t.commentShow?n("Comment",{attrs:{comicsId:t.searchParam.param}}):t._e()],1)])])},staticRenderFns:[]};var g=n("VU/8")(p,f,!1,function(t){n("uYxP")},"data-v-e2167584",null);e.default=g.exports},Mhyx:function(t,e,n){var i=n("/bQp"),o=n("dSzd")("iterator"),r=Array.prototype;t.exports=function(t){return void 0!==t&&(i.Array===t||r[o]===t)}},"NWt+":function(t,e,n){var i=n("+ZMJ"),o=n("msXi"),r=n("Mhyx"),s=n("77Pl"),a=n("QRG4"),c=n("3fs2"),u={},l={};(e=t.exports=function(t,e,n,m,d){var h,v,p,f,g=d?function(){return t}:c(t),A=i(n,m,e?2:1),C=0;if("function"!=typeof g)throw TypeError(t+" is not iterable!");if(r(g)){for(h=a(t.length);h>C;C++)if((f=e?A(s(v=t[C])[0],v[1]):A(t[C]))===u||f===l)return f}else for(p=g.call(t);!(v=p.next()).done;)if((f=o(p,A,v.value,e))===u||f===l)return f}).BREAK=u,e.RETURN=l},"RY/4":function(t,e,n){var i=n("R9M2"),o=n("dSzd")("toStringTag"),r="Arguments"==i(function(){return arguments}());t.exports=function(t){var e,n,s;return void 0===t?"Undefined":null===t?"Null":"string"==typeof(n=function(t,e){try{return t[e]}catch(t){}}(e=Object(t),o))?n:r?i(e):"Object"==(s=i(e))&&"function"==typeof e.callee?"Arguments":s}},U5ju:function(t,e,n){n("M6a0"),n("zQR9"),n("+tPU"),n("CXw9"),n("EqBC"),n("jKW+"),t.exports=n("FeBl").Promise},Xfx4:function(t,e){},bRrM:function(t,e,n){"use strict";var i=n("7KvD"),o=n("FeBl"),r=n("evD5"),s=n("+E39"),a=n("dSzd")("species");t.exports=function(t){var e="function"==typeof o[t]?o[t]:i[t];s&&e&&!e[a]&&r.f(e,a,{configurable:!0,get:function(){return this}})}},dNDb:function(t,e){t.exports=function(t){try{return{e:!1,v:t()}}catch(t){return{e:!0,v:t}}}},dY0y:function(t,e,n){var i=n("dSzd")("iterator"),o=!1;try{var r=[7][i]();r.return=function(){o=!0},Array.from(r,function(){throw 2})}catch(t){}t.exports=function(t,e){if(!e&&!o)return!1;var n=!1;try{var r=[7],s=r[i]();s.next=function(){return{done:n=!0}},r[i]=function(){return s},t(r)}catch(t){}return n}},fJUb:function(t,e,n){var i=n("77Pl"),o=n("EqjI"),r=n("qARP");t.exports=function(t,e){if(i(t),o(e)&&e.constructor===t)return e;var n=r.f(t);return(0,n.resolve)(e),n.promise}},"jKW+":function(t,e,n){"use strict";var i=n("kM2E"),o=n("qARP"),r=n("dNDb");i(i.S,"Promise",{try:function(t){var e=o.f(this),n=r(t);return(n.e?e.reject:e.resolve)(n.v),e.promise}})},knuC:function(t,e){t.exports=function(t,e,n){var i=void 0===n;switch(e.length){case 0:return i?t():t.call(n);case 1:return i?t(e[0]):t.call(n,e[0]);case 2:return i?t(e[0],e[1]):t.call(n,e[0],e[1]);case 3:return i?t(e[0],e[1],e[2]):t.call(n,e[0],e[1],e[2]);case 4:return i?t(e[0],e[1],e[2],e[3]):t.call(n,e[0],e[1],e[2],e[3])}return t.apply(n,e)}},kvWB:function(t,e){},msXi:function(t,e,n){var i=n("77Pl");t.exports=function(t,e,n,o){try{return o?e(i(n)[0],n[1]):e(n)}catch(e){var r=t.return;throw void 0!==r&&i(r.call(t)),e}}},qARP:function(t,e,n){"use strict";var i=n("lOnJ");t.exports.f=function(t){return new function(t){var e,n;this.promise=new t(function(t,i){if(void 0!==e||void 0!==n)throw TypeError("Bad Promise constructor");e=t,n=i}),this.resolve=i(e),this.reject=i(n)}(t)}},t8x9:function(t,e,n){var i=n("77Pl"),o=n("lOnJ"),r=n("dSzd")("species");t.exports=function(t,e){var n,s=i(t).constructor;return void 0===s||void 0==(n=i(s)[r])?e:o(n)}},uYxP:function(t,e){},"xH/j":function(t,e,n){var i=n("hJx8");t.exports=function(t,e,n){for(var o in e)n&&t[o]?t[o]=e[o]:i(t,o,e[o]);return t}}});
//# sourceMappingURL=0.5df23672e23c18c6078e.js.map