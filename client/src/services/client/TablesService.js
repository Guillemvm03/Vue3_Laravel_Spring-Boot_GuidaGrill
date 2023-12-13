import Api from '../Api'
import secrets from '../../../secrets.example'


export default {

    FormatFilters(params) {
        let params_ = [];
        Object.entries(params).forEach(item => {
            if (item[0] === 'menus' && item[1].length > 0) {
                const menu = item[1].map(item => `menu=${item}`).join('&');
                params_.push(menu)
            } else if (item[1] != null) {
                params_.push(`${item[0]}=${item[1]}`);
            }
        });

        return params_.join('&')
    },

    getTables(params){
        console.log(params);
        return Api(secrets.URL_SPRING).get(`tables?${this.FormatFilters(params)}`)     
    },
    GetTableById(id) {
        return Api(secrets.URL_SPRING).get('tables/' + id);
    },
    GetTablesPaginate(params) {
        return Api(secrets.URL_SPRING).get(`tables/paginate?${this.FormatFilters(params)}`);
    },



}