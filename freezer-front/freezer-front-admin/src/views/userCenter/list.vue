<template>
    <form action="/user/login" id="userLoginForm" method="post">
        <li class="ds" >
            <label class="fa fa-user">::before</label>
            <input name="username" id="username" placeholder="员工账号" required="required">
        </li>
        <li class="ds" >
            <label class="fa fa-lock">::before</label>
            <input name="password" id="password" type="password" placeholder="密码" required="required">
        </li>
        <li class="ds">
            <el-button @click="login()">
        </li>
    </form>
</template>