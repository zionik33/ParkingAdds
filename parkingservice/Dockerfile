FROM node:argon

#Make dir
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

RUN npm install -g swagger
RUN npm install -g nodemon

COPY package.json /usr/src/app
RUN npm install

COPY . /usr/src/app
EXPOSE 12000

CMD ["nodemon", "app.js"]