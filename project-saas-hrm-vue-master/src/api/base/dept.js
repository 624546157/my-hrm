import {
     createAPI, createFileAPI
   } from '@/utils/request'
   export const organList = data => createAPI('/company/deparment/getOrgin', 'get', data)
   export const save = data => createAPI('/company/deparment/save', 'post', data)
   export const update = data => createAPI('/company/deparment/${data.id}', 'put', data)
   export const find = data => createAPI('/company/deparment/${data.id}', 'get', data)
   export const remove = data => createAPI('/company/deparment/${data.id}', 'delete', 
   data)
   export const changeDept = data => createAPI(`/company/deparment/changeDept`, 'put', 
   data)
   //export const saveOrUpdate =   => {return data.id?save(data):add(data)}