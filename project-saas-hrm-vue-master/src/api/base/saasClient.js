import {createAPI, createFormAPI} from '@/utils/request'

export const list = data => createAPI('/company/findAll', 'get', data)
export const detail = data => createAPI(`/company/findById`, 'get', data)
